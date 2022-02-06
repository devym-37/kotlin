package com.example.gallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    // 뷰페이저가 표시할 프래그먼트 목록
    private val items = ArrayList<Fragment>()

    override fun getCount(): Int {
        TODO("Not yet implemented")
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
        return items[position]
    }

    fun updateFragments(items : List<Fragment>) {
        this.items.addAll(items)
    }
}