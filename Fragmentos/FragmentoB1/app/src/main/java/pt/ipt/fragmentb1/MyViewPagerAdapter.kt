package pt.ipt.fragmentb1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import pt.ipt.fragmentb1.fragments.Fragment1
import pt.ipt.fragmentb1.fragments.Fragment2
import pt.ipt.fragmentb1.fragments.Fragment3

class MyViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)  {
    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return Fragment1()
            1 -> return Fragment2()
            2 -> return Fragment3()
            else -> return Fragment1()
        }
    }

    override fun getItemCount(): Int {
        return 3;
    }

}