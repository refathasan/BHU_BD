package com.refathasan.bhu_bd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.refathasan.bhu_bd.fragments.ICCRHealthInsuranceFragment
import com.refathasan.bhu_bd.fragments.PayFeesFragment
import com.refathasan.bhu_bd.fragments.PrimaryFromFillUpFragment

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.main_drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)
        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.primary_from_fill_up -> {
                    loadFragment(PrimaryFromFillUpFragment())
                }
                R.id.pay_fees -> {
                    loadFragment(PayFeesFragment())
                }
                R.id.iccr_hlt_inc->{
                    loadFragment(ICCRHealthInsuranceFragment())
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransection: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransection.add(R.id.container, fragment)
        fragmentTransection.commit()
    }
}