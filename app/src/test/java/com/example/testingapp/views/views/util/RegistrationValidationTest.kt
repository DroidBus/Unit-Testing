package com.example.testingapp.views.views.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
 class RegistrationValidationTest{

     @Test
     fun `validate username returns false`(){
         val username="Shweta"
         val password="123"
         val confirmedPassword= "123"
         val result= RegistrationValidation.validate(username,password,confirmedPassword)

         //assertThat(result).isEqualTo(false)
         assertThat(result).isFalse()

     }


    @Test
    fun `valid username and correctly repeated password  returns true`(){
        val username="Shweta@"
        val password="123"
        val confirmedPassword= "123"
        val result= RegistrationValidation.validate(username,password,confirmedPassword)

        //assertThat(result).isEqualTo(false)
        assertThat(result).isTrue()
        assertThat(username).contains("@")
        assertThat(username).isNotEmpty()

    }


    @Test
    fun `username already exists returns false`(){
        val username="Carl"
        val password="123"
        val confirmedPassword= "123"
        val result= RegistrationValidation.validate(username,password,confirmedPassword)

        //assertThat(result).isEqualTo(false)
        assertThat(result).isFalse()


    }


    //password is empty
    @Test
    fun `empty password returns false`(){
        val username= "Shweta"
        val password= ""
        val confirmedPassword= "123"
        val result= RegistrationValidation.validate(username,password,confirmedPassword)

        //assertThat(result).isEqualTo(false)
        assertThat(result).isFalse()


    }


    //password repeated incorrrectly
    @Test
    fun `password repeated incorrectly return false`(){
        val username= "Shweta"
        val password= "234"
        val confirmedPassword= "123"
        val result= RegistrationValidation.validate(username,password,confirmedPassword)

        //assertThat(result).isEqualTo(false)
        assertThat(result).isFalse()


    }


    //password contains less than 2 digits
    @Test
    fun `password contains less than 2 digits return false`(){
        val username= "Shweta"
        val password= "2"
        val confirmedPassword= "123"
        val result= RegistrationValidation.validate(username,password,confirmedPassword)

        assertThat(result).isFalse()


    }


}