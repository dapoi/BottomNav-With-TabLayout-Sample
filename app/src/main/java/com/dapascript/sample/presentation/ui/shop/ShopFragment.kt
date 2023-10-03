package com.dapascript.sample.presentation.ui.shop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dapascript.sample.R
import com.dapascript.sample.databinding.FragmentShopBinding
import com.dapascript.sample.presentation.adapter.ShopPagerAdapter
import com.dapascript.sample.utils.BaseFragment
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import com.google.android.material.tabs.TabLayoutMediator

class ShopFragment : BaseFragment<FragmentShopBinding>(FragmentShopBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
    }

    private fun initViewPager() {
        binding.viewPager2.apply {
            adapter = ShopPagerAdapter(activity as AppCompatActivity)

            // custom layout for tab
            val tabLayout = binding.tabLayout
            TabLayoutMediator(tabLayout, this) { tab, position ->
                tab.text = TAB_TITLES[position]
                tab.setIcon(TAB_ICON_FALSE[position])
            }.attach()

            // change icon when tab selected
            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: Tab) {
                    tab.setIcon(TAB_ICON_TRUE[tab.position])
                }

                override fun onTabUnselected(tab: Tab) {
                    tab.setIcon(TAB_ICON_FALSE[tab.position])
                }

                override fun onTabReselected(tab: Tab) {}
            })
        }
    }

    companion object {
        private val TAB_ICON_FALSE = arrayOf(
            R.drawable.ic_internet_false,
            R.drawable.ic_roaming_false
        )

        private val TAB_ICON_TRUE = arrayOf(
            R.drawable.ic_internet_true,
            R.drawable.ic_roaming_true
        )

        private val TAB_TITLES = arrayOf(
            "Internet",
            "Roaming"
        )
    }
}