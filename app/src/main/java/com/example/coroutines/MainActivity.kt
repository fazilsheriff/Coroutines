package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate: " + " Let's begin")
        runBlocking {
            launch {
                launch {
                    delay(5000)
                    Log.i(TAG, "onCreate: " + " coroutine ONE")
                }
               GlobalScope.launch {
                    delay(1000)
                    Log.i(TAG, "onCreate: " + " coroutine TWO")

                }
            }
            Log.i(
                TAG,
                "onCreate: " + " Only when the children inside runBlocking complete, execution follows on this line"
            )
        }
    }}




   

