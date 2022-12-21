package com.example.testingapp.views.views.util

object BookShelf {
    var books= arrayListOf<Book>()

    fun showBooks(){
        for(i in books){
            println(i)
        }
    }
}