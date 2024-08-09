package com.example.coroutines

import retrofit2.Retrofit

class Repository(private val apiClient: Retrofit) {

    suspend fun getCurrencyByName(name: String): BitcoinResponse {
        val apiInterface = apiClient.create(ApiInterface::class.java)
        return apiInterface.getCryptoByName(name)
    }
}