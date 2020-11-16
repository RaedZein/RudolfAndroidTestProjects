package com.example.android.viewpager2android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.android.viewpager2android.fragments.FavouritesFragment
import com.example.android.viewpager2android.fragments.HomeFragment
import com.example.android.viewpager2android.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
                R.drawable.android1,
                R.drawable.android2,
                R.drawable.android3,
                R.drawable.android4,
                R.drawable.android5,
                R.drawable.android6
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        val homeFragment = HomeFragment()
        val favouritesFragment = FavouritesFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_favorite -> makeCurrentFragment(favouritesFragment)
                R.id.ic_settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }

    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}