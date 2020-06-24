package com.gvelesiani.shopapp.auth

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gvelesiani.shopapp.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

    }

    private fun init() {
        setTextSignUp()
    }

    private fun setText(text: String, color: Int, textView: TextView) {
        val spannable: Spannable = SpannableString(text)

        spannable.setSpan(
            ForegroundColorSpan(color),
            0,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.append(spannable)

    }

    private fun setTextSignUp() {
        setText(
            getString(R.string.new_user),
            ContextCompat.getColor(this, R.color.newUser),
            signUpTextView
        )
        setText(
            getString(R.string.sign_up),
            ContextCompat.getColor(this, R.color.signUp),
            signUpTextView
        )
        setText(
            getString(R.string.here),
            ContextCompat.getColor(this, R.color.newUser),
            signUpTextView
        )
    }

}