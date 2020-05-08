package com.hb.darkmode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        checkbox_daynight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) shouldEnableDarkMode(DarkModeConfig.YES)
            else shouldEnableDarkMode(DarkModeConfig.NO)
        }
    }


    enum class DarkModeConfig {
        YES,
        NO,
        FOLLOW_SYSTEM
    }

    private fun shouldEnableDarkMode(darkModeConfig: DarkModeConfig) {
        when (darkModeConfig) {
            DarkModeConfig.YES -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            DarkModeConfig.NO -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            DarkModeConfig.FOLLOW_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}
