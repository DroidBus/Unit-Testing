package com.example.testingapp.views.views.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testingapp.R

class AddSpendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_spend)
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout,AddSpendFragment())
            .commit()
    }
}