package com.example.testingapp.views.views.util

object LoginUtils {

    fun validate(username:String,email:String, password:String,age:Int):String?{
        if(username.isEmpty()) return "Please enter username"
        if(username.length < 6) return "very short username"
        if(username.length>6) return "very long username"

        if(email.isEmpty()) return "Please enter email"

        if(!email.contains("@")) return "Please enter valid email"

        if(email.filter { it.isDigit() }.isEmpty())  return "email must contain at least one digit"

        if(password.isEmpty()) return "Please enter password"

        if(password.length<6) return "Please enter valid password"

        if(age==0) return "Please enter valid age"

        if(age<18) return "Not eligible"


        return null

    }
}