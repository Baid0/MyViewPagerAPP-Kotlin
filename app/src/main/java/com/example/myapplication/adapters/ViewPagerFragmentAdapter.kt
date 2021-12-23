package com.example.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragments.FragmentOne
import com.example.myapplication.fragments.FragmentSecond
import com.example.myapplication.fragments.FragmentThree


class ViewPagerFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {


    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> FragmentOne()
            1 -> FragmentSecond()
            2 -> FragmentThree()
            else -> FragmentOne()
        }

    }
}