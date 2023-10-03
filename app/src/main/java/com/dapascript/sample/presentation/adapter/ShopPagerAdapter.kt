package com.dapascript.sample.presentation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dapascript.sample.presentation.ui.shop.ShopInternetFragment
import com.dapascript.sample.presentation.ui.shop.ShopRoamingFragment

class ShopPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ShopInternetFragment()
        1 -> ShopRoamingFragment()
        else -> throw IllegalArgumentException("Invalid fragment position")
    }
}