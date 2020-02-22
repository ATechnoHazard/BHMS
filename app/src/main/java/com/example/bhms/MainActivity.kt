package com.example.bhms

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val spannable = SpannableString("BHMS")
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.toolbar_text_color)),
            2, 4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        toolbar_text.text = spannable

        setupActionBarWithNavController(nav_host_fragment.findNavController())
    }
}
