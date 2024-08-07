package com.example.coroutines

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun firstWork(onFinished: (result: String) -> Unit) {
        Thread {
            Thread.sleep(1000)
            onFinished("Work 1 done")
        }.start()
    }

    fun secondWork(previousResult: String, onFinished: (result: String) -> Unit) {
        Thread {
            Thread.sleep(1000)
            onFinished("$previousResult Work 2 done")
        }.start()
    }

    fun thirdWork(previousResult: String, onFinished: (result: String) -> Unit) {
        Thread {
            Thread.sleep(1000)
            onFinished("$previousResult Work 3 done")
        }.start()
    }

    fun fourWork(previousResult: String, onFinished: (result: String) -> Unit) {
        Thread {
            Thread.sleep(1000)
            onFinished("$previousResult Work 4 done")
        }.start()
    }
}