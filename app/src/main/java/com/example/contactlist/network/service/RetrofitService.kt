package com.example.contactlist.network.service

import com.example.contactlist.network.`interface`.RetrofitDAO
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    // Should be instantiated in Retrofit Service
    private val service = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(RetrofitDAO::class.java)

    fun getService():RetrofitDAO{

        return service

    }
}