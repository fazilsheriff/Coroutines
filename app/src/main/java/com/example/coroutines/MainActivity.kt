package com.example.coroutines
/*
* 1 What is the difference between IO,Default and Main
* 2 What is Coroutines
* 3 What are the methods in coroutines
* */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RestrictTo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private  val RESULT_1="RESULT #1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClcik.setOnClickListener{
            CoroutineScope(Main).launch {
                fnNetworkCallOn()
            }
        }
    }
    private suspend fun getResult1API():String
    {
        logThread("getResult1API")
        delay(1000)
        return RESULT_1
    }
//    debug: ${methodName}: ${Thread.currentThread().name
    private fun logThread(methodName: String) {
        println("debug: ${methodName} ${Thread.currentThread().name}")

    }
    private suspend fun fnNetworkCallOn() {
        var result=getResult1API()
        withContext(Main){
            displayThreadValuesOnUI(result)

        }
    }
    private fun displayThreadValuesOnUI(result:String) {

        var newText= "\n $result"
        txtHello.text=newText

    }
}