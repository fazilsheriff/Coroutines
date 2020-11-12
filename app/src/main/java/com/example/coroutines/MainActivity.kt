package com.example.coroutines
// 1 What is deffered
// 2 What is Await

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

            val jobDeffered1: Deferred<Int> = async {
                for(i in 0..20) {
                    delay(500)
                    Log.i(TAG, "onCreate: " + " coroutine ONE $i" + Thread.currentThread().name)
                }
                15
            }


            val jobDeffered2: Deferred<Int> = async {
                delay(50)
                Log.i(TAG, "onCreate: " + " coroutine ONE" + Thread.currentThread().name)
                5
            }

            var a=jobDeffered1.await()
            var b=jobDeffered2.await()
            Log.i(TAG, "onCreate: Adding a+b="+(a+b))

        }
        }
    }




   

