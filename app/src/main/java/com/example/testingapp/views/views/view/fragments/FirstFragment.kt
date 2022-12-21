package com.example.testingapp.views.views.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class FirstFragment: Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("First Fragment","onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




}