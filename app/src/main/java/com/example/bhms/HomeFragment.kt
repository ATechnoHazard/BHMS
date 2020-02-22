package com.example.bhms

import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.bhms.utils.hide
import com.example.bhms.utils.toast
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spannable = SpannableString(textView.text.toString())
        spannable.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.toolbar_text_color
                )
            ),
            8, 13,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable

        dismiss_banner_button.setOnClickListener { header_card.hide() }
        submit_fab.setOnClickListener {
            delay_til.error = null
            if (delay_til.editText?.text.isNullOrBlank()) {
                delay_til.error = "Please enter a valid value"
                return@setOnClickListener
            }

            Handler().postDelayed({
                toast("Delay successfully set to " + delay_til.editText?.text.toString() + "ms")
            }, 2000)

        }
    }
}
