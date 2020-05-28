package com.example.soptseminar4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.time.toDuration

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btn_login.setOnClickListener {

            var isEmpty:Boolean=false
            if(et_id.text.toString().isNullOrBlank()) {
                login_toast1.visibility=View.VISIBLE
                isEmpty=true
            }
            if(et_pw.text.toString().isNullOrBlank()){
                login_toast2.visibility=View.VISIBLE
                isEmpty=true
            }
            // id, pw 다 차 있으면 로그인, 안 차 있으면 toast
            if(isEmpty){
                this.showCustomToast("빈칸 없이 입력해주세요")

            }else{
                loginToServer(et_id.text.toString(),et_pw.text.toString())


            }

        }
    }
    fun loginToServer(id:String, pw:String){

        val requestToServer=RequestToServer

        requestToServer.service.requestLogin(
            RequestLogin(
                id = id
                ,password = pw
            )
        ).customEnqueue(
            onError = {Log.d("error", "error")},
            onSuccess = {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        )

    }

}
