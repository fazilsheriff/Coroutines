package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private  val TAG = "Coroutines"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClcik.setOnClickListener{
           CoroutineScope(Main).launch {

               thirdMethod()
               secondMethod()
           }
        }
    }

     fun firstMethod() {
         Log.i(TAG, "firstMethod: Is executed")
    }

    suspend fun secondMethod(){
        Log.i(TAG, "secondMethod: Is executed")
    }

     suspend fun thirdMethod(){
        Log.i(TAG, "ThridMethod: Is executed")
         firstMethod()


     }
   

}