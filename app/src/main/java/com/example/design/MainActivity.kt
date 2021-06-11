package com.example.design

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.design.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter
    private lateinit var viewPager2: ViewPager
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashScreen)
        super.onCreate(savedInstanceState)
        setTheme(R.style.Base_Theme_AppCompat_Light_DarkActionBar)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.intro_custom_action_bar)
        val parent = supportActionBar!!.customView.parent as Toolbar
        parent.setContentInsetsAbsolute(0,0)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        viewPager2 = binding.viewpager
        viewPager2.adapter = viewPagerFragmentAdapter

        binding.skip.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }



    }
}