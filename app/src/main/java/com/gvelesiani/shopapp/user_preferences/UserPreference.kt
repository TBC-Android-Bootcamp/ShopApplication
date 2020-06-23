package com.gvelesiani.shopapp.user_preferences

import android.content.Context
import com.gvelesiani.shopapp.App

object UserPreference {

    const val USER_ID = "USER_ID"

    private val preference by lazy {
        App.instance.getContext().getSharedPreferences("USER", Context.MODE_PRIVATE)
    }

    private val editor by lazy {
        preference.edit()
    }

    fun saveString(key:String, value:String){
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key:String) = preference.getString(key, "")

    fun removeString(key:String){
        if(preference.contains(key)) {
            editor.remove(key)
            editor.commit()
        }
    }

    fun clearAll(){
        editor.clear()
        editor.commit()
    }
}