package com.gvelesiani.shopapp.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gvelesiani.shopapp.MainActivity
import com.gvelesiani.shopapp.R
import com.gvelesiani.shopapp.auth.LoginActivity
import com.gvelesiani.shopapp.user_preferences.UserPreference

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()
    private val runnable = Runnable {
        init()
    }

    private fun postDelayed(){
        handler.postDelayed(runnable, 2000)
    }

    private fun removeCallback(){
       handler.removeCallbacks(runnable)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        postDelayed()
    }

    override fun onPause() {
        super.onPause()
        removeCallback()
    }

    private fun init(){
        val activity: Activity = if(UserPreference.getString(UserPreference.USER_ID)!!.isEmpty())
            LoginActivity()
        else
            MainActivity()

        val intent = Intent(this, activity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}