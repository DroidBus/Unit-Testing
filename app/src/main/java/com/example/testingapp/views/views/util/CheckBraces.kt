package com.example.testingapp.views.views.util

object CheckBraces {

    /*
    * Checks if the braces are set correctly
    * e.g. "( a * b ) should return false
    * */

    fun checkBraces(input:String):Boolean{
        return input.count { it == '(' } == input.count { it == ')' }
    }
}