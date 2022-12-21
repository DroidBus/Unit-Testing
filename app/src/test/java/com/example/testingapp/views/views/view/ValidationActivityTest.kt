package com.example.testingapp.views.views.view

import com.example.testingapp.views.views.util.LoginUtils
import org.junit.After
import org.junit.Before
import org.junit.Test


class ValidationActivityTest{

    @Before
    fun setUp(){

    }

    @After
    fun tearDown(){

    }

    @Test
    fun username_is_empty(){
      val username=""
      val assert= LoginUtils.validate(username,"jhds@g","hdjkshd",20)
        assert(assert== "Please enter username")
    }

    @Test
    fun username_length_less_than_6(){
        val username= "djshd"
        assert(LoginUtils.validate(username,"hdjka","hsdjk",20)=="very short username")
    }


    @Test
    fun username_length_very_long(){
       val username="fjsl djashdashdlasjdlk asdhals"
        assert(LoginUtils.validate(username,"jdhjsajda","hsdkja",27)=="very long username")
    }


}