package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private  val TAG = "Coroutines"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate: Stated the Main Thread, ${Thread.currentThread().name}")

            runBlocking {
             var timeSec=   measureTimeMillis {
                    var firstResult:Deferred<String> =async(start = CoroutineStart.LAZY) {
                        firstMethod()
                    }
                 var   secondResult=async {
                     secondMethod()
                 }

//                    Log.i(TAG, "onCreate: "+firstResult.await())
//                    Log.i(TAG, "onCreate: "+secondResult.await())
                }
                Log.i(TAG, "Time taken to complete in sec $timeSec")

            }

       }

        suspend fun firstMethod(): String {
            delay(3000L)
            return "Hello"
        }

    suspend fun secondMethod(): String {
        delay(3000L)
        return "World"
    }
    }



   

