package com.example.testingapp.views.views.util

object ValidateAddSpend {

     fun validateAddSpend(amount:Int, desc:String): Boolean{

         return amount in 1000..10000

         if(desc.length in 10..50) return true else false

         return  desc.length in 10..50


    }
}