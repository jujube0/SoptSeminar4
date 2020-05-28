package com.example.soptseminar4

import android.content.Context
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.toast_for_login.view.*
import java.util.zip.Inflater

fun Context.showCustomToast(msg:String){

    val inflater: LayoutInflater = LayoutInflater.from(this)


    val toast_view : View = inflater.inflate(R.layout.toast_for_login, null)

    toast_view.textView3.text=msg

    val toast= Toast(this)
    toast.view=toast_view
    toast.duration=Toast.LENGTH_SHORT
    toast.show()
    toast.setGravity(Gravity.BOTTOM,0,61)

}