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
        Log.i(TAG, "onCreate:Main Start "+Thread.currentThread().name)
        GlobalScope.launch{
            delay(5000)
            Log.i(TAG, "onCreate:GlobalScope  1"+Thread.currentThread().name)
//
//            Log.i(TAG, "onCreate: Inside the globalScope")
//            Log.i(TAG, "onCreate: Hello")
        }
        GlobalScope.launch {

            Log.i(TAG, "onCreate:GlobalScope2 "+Thread.currentThread().name)
            runBlocking {
                delay(8000)
                Log.i(TAG, "onCreate:Inside Run Blocking "+Thread.currentThread().name)
            }

        }

        Log.i(TAG, "onCreate:Main End "+Thread.currentThread().name)

        btnClcik.setOnClickListener{



            }
        }
    }



   

