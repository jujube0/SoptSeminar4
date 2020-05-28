package com.example.soptseminar4

data class ResponseLogin(
    val status:Int,
    val success:Boolean,
    val message:String,
    val data: SomeData?
)
data class SomeData(
    val jwt:String
)