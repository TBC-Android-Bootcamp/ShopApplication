package com.gvelesiani.shopapp.auth

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.Log.d
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gvelesiani.shopapp.R
import com.gvelesiani.shopapp.tools.Tools
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_window.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

    }

    private fun init() {
        setTextSignUp()
        etEmail.addTextChangedListener(textWatcher)

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

    fun logIn(v: View){
        val email = etEmail.text.toString()
        if(!Tools.isEmailValid(email)) {
            Tools.dialog(this, getString(R.string.incorrect_request), getString(R.string.email_is_invalid))
        }
        else {
            if(etPassword.text.isNotEmpty()){
                d("etPassword", "password isn't empty / success")
            } else {
                Tools.dialog(this, getString(R.string.incorrect_request), getString(R.string.password_is_empty))
            }
        }
    }


    fun forgotPassword(v:View){

    }

    fun rememberMe(v: View){
        if(ivRememberMe.tag == "0"){
            ivRememberMe.setImageResource(R.mipmap.ic_checked)
            ivRememberMe.tag = "1"
        } else {
            ivRememberMe.setImageResource(R.mipmap.ic_unchecked)
            ivRememberMe.tag = "0"
        }
    }

    private fun isEmailValid(isValid:Boolean){
        var drawable:Drawable? = null
        if(isValid)
            drawable = ContextCompat.getDrawable(this, R.mipmap.etdrawableicon)
        etEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable ,null )
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            d("....", "..")
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            d("....", ".")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            isEmailValid(Tools.isEmailValid(s.toString()))
        }

    }
}