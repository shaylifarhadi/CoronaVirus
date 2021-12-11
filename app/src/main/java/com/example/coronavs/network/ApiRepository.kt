package com.example.coronavs.network

import com.example.coronavs.network.erorhandling.Resource
import com.example.coronavs.network.datamodel.ResponseCorona

interface ApiRepository {
    suspend fun getCorona(): Resource<ResponseCorona>
}