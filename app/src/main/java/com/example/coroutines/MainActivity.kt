package com.example.coroutines
// Cancellation
// 1 What are the scenarios u can cancel the coroutine
// 2 Cancel the coroutine in a for loop
// 3 Cancel the coroutine in a time loop
// 4



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RestrictTo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private  val TAG = "coroutines"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var alien=Alien()
        var aliennJav=AliennJav("Duar")
        Log.i(TAG, "onCreate:Name ${aliennJav.name}")
        aliennJav.name="No Name"
        Log.i(TAG, "onCreate: ${aliennJav.name}")
        
        alien.name="Fahad"
        alien.fathersName="Fazil"
        Log.i(TAG, "onCreate: Name:${alien.name}")
        Log.i(TAG, "onCreate: FathersName:${alien.fathersName}")
        var a:Int=5
        var b =2
        var result=0
        result =if(a>b)
            a
        else
           b

        Log.i(TAG, "onCreate: Greater number  is $result")


        runBlocking {


            Log.i(TAG, "onCreate: RunBlocking $this")

            launch {
                Log.i(TAG, "onCreate: launch $this")
            }

            async {
                Log.i(TAG, "onCreate: async $this")

            }
        }
        fun testRunFunction() {

        }

      }




        }





   

