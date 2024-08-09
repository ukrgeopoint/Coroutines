package com.example.coroutines

import kotlinx.coroutines.delay

object Coroutines {

    private suspend fun firstWork(): String {
        delay(1000)
        return "Work 1 is finished"
    }

    private suspend fun secondWork(): String {
        delay(1000)
        return "Work 2 is finished"
    }

    private suspend fun thirdWork(): String {
        delay(1000)
        return "Work 3 is finished"
    }

    private suspend fun fourWork(): String {
        delay(1000)
        return "Work 4 is finished"
    }

    suspend fun doWork(): String {
        val firstWorkResult = firstWork()
        val secondWorkResult = secondWork()
        val thirdWorkResult = thirdWork()
        val fourWorkResult = fourWork()
        return "$firstWorkResult $secondWorkResult $thirdWorkResult $fourWorkResult"
    }
}