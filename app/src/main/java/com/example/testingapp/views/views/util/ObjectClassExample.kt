package com.example.testingapp.views.views.util

fun main(args:Array<String>){

    BookShelf.books.add(Book("Java",50))
    BookShelf.books.add(Book("C++",40))
    BookShelf.books.add(Book("Kotlin",60))

    BookShelf.showBooks()
}