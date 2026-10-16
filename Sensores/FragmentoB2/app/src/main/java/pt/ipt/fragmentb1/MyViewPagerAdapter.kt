package pt.ipt.fragmentb1

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import pt.ipt.fragmentb1.fragments.Fragment1
import pt.ipt.fragmentb1.fragments.Fragment2
import pt.ipt.fragmentb1.fragments.Fragment3

class MyViewPagerAdapter(private val parent: MainActivity): FragmentStateAdapter(parent)  {
    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return Fragment1(parent)
            1 -> return Fragment2(parent)
            2 -> return Fragment3(parent)
            else -> return Fragment1(parent)
        }
    }

    override fun getItemCount(): Int {
        return 3;
    }

}