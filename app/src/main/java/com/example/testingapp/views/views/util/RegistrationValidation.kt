package com.example.testingapp.views.views.util

import androidx.core.text.isDigitsOnly

object RegistrationValidation {

    val existingUsers= listOf("Peter", "Carl")
/*
     if the username is already taken
     if the username is empty
     if the passowrd is empty
     if the confirmed password is empty
     if the password and confirmed password are not same
*/



    fun validate(username:String
                 ,password:String
                 ,confirmPassword:String):Boolean
    {

        if(username.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
            return false
        }

        if(username in existingUsers){
            return false
        }

        if(confirmPassword != password){
            return false
        }

        if(password.count { it.isDigit() } <2){
            return false
        }

       return true
    }
}