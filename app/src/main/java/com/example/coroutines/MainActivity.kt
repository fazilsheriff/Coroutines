package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClcik.setOnClickListener{
            fnNetworkCallOn()
        }
    }

    private fun fnNetworkCallOn() {

    }

   

}