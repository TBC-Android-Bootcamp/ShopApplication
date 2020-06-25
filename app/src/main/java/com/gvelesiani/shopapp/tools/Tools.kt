package com.gvelesiani.shopapp.tools

import android.app.Dialog
import android.content.Context
import android.util.Patterns
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.gvelesiani.shopapp.R
import kotlinx.android.synthetic.main.dialog_window.*

object Tools {
    fun isEmailValid(text:String) = Patterns.EMAIL_ADDRESS.matcher(text).matches()

    // dialog
    fun dialog(context:Context, title: String, description: String){
        val dialog = Dialog(context)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_window)

        val params: ViewGroup.LayoutParams=dialog.window!!.attributes
        params.width= ViewGroup.LayoutParams.MATCH_PARENT
        params.height= ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes=params as WindowManager.LayoutParams
        dialog.dialogbtn.setOnClickListener(){
            dialog.dismiss()
        }
        dialog.dialogtitle.text = title
        dialog.dialgdesc.text = description
        dialog.show()
    }
}