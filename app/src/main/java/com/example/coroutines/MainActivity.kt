package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    val JOB_TIME_OUT=1100L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClcik.setOnClickListener{
            CoroutineScope(IO).launch {
                fnNetworkCallOn()

            }
        }
    }

    private suspend fun fnNetworkCallOn() {

        withContext(IO){

            val job= withTimeoutOrNull(JOB_TIME_OUT) {
            val    job1=getResultFromAPI()
            moveTextTOMainThread(job1)
            }
    if(job==null)
    {
        var cancelMSG="Job got Cancelled. Times Out is $JOB_TIME_OUT ms"
        moveTextTOMainThread(cancelMSG)
    }

        }

    }

    private suspend fun moveTextTOMainThread(text: String) {
        withContext(Main){
            updateText(text)
        }

    }

    private fun updateText(text: String) {
        txtHello.text=text

    }

    private suspend fun getResultFromAPI(): String {

        delay(1000)
        return "API ONE"
    }


}