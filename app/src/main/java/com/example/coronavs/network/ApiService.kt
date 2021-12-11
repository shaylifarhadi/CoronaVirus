package com.example.coronavs.network

import com.example.coronavs.network.datamodel.ResponseCorona
import retrofit2.http.GET

interface ApiService {

    @GET("/summary")
    suspend fun getCorona(): ResponseCorona
}