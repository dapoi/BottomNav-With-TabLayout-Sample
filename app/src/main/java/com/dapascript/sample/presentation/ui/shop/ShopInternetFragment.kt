package com.dapascript.sample.presentation.ui.shop

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapascript.sample.R
import com.dapascript.sample.data.model.PackageEntity
import com.dapascript.sample.data.source.PackageInternet
import com.dapascript.sample.databinding.FragmentShopInternetBinding
import com.dapascript.sample.databinding.ItemShopBinding
import com.dapascript.sample.utils.BaseFragment
import com.dapascript.sample.utils.BaseListAdapter
import com.google.android.material.chip.Chip
import java.text.NumberFormat
import java.util.Locale

class ShopInternetFragment : BaseFragment<FragmentShopInternetBinding>(
    FragmentShopInternetBinding::inflate
) {

    private lateinit var baseAdapter: BaseListAdapter<PackageEntity>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initChip()
        initAdapter()
    }

    private fun initChip() {
        val whiteStateList = ContextCompat.getColorStateList(requireContext(), R.color.white_base)
        val blueStateList = ContextCompat.getColorStateList(requireContext(), R.color.blue_night)
        val blackColor = ContextCompat.getColor(requireContext(), R.color.black)
        val dataChip = listOf("Harga Terendah", "Harga Tertinggi")
        dataChip.forEach {
            val chip = Chip(context).apply {
                text = it
                isCheckable = true
                chipCornerRadius = 18f
                isCheckedIconVisible = false
                chipBackgroundColor = whiteStateList
                chipStrokeColor = blueStateList
                chipStrokeWidth = 3f
                setTextColor(blackColor)
            }

            binding.cgPrize.apply {
                isSingleSelection = true
                addView(chip)
            }

            chip.closeIcon = ContextCompat.getDrawable(
                requireContext(),
                androidx.appcompat.R.drawable.abc_ic_clear_material
            )

            chip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    chip.chipBackgroundColor = blueStateList
                    chip.setTextColor(whiteStateList)
                    chip.isCloseIconVisible = true
                    chip.closeIconTint = whiteStateList

                    baseAdapter.currentList.let { list ->
                        if (it.contains("Terendah")) {
                            submitItems(list.sortedBy { it.price })
                        } else {
                            submitItems(list.sortedByDescending { it.price })
                        }
                    }
                } else {
                    chip.chipBackgroundColor = whiteStateList
                    chip.setTextColor(blackColor)
                    chip.isCloseIconVisible = false
                    submitItems(PackageInternet.packageInternet())
                }
            }

            chip.setOnCloseIconClickListener {
                chip.isChecked = false
                chip.chipBackgroundColor = whiteStateList
                chip.setTextColor(blackColor)
                chip.isCloseIconVisible = false
                submitItems(PackageInternet.packageInternet())
            }
        }
    }

    private fun initAdapter() {
        baseAdapter = BaseListAdapter(
            { layoutInflater, parent, attachToParent ->
                ItemShopBinding.inflate(
                    layoutInflater,
                    parent,
                    attachToParent
                )
            },
            { item, binding ->
                (binding as ItemShopBinding).apply {
                    tvTitle.text = item.title
                    tvDuration.text = item.description
                    tvPrice.text = NumberFormat.getCurrencyInstance(
                        Locale("in", "ID")
                    ).format(item.price)
                }
            },
            { old, new -> old.title == new.title },
            { old, new -> old == new }
        )

        binding.rvShopInternet.apply {
            adapter = baseAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        submitItems(PackageInternet.packageInternet())
    }

    private fun submitItems(items: List<PackageEntity>) {
        baseAdapter.setItems(items) {
            binding.rvShopInternet.scrollToPosition(0)
        }
    }
}