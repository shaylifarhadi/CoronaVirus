package com.example.coronavs.network.datamodel


import com.squareup.moshi.Json

data class ResponseCorona(
    @Json(name = "Countries")
    val countries: List<Country>?,
    @Json(name = "Date")
    val date: String?,
    @Json(name = "Global")
    val global: Global?,
    @Json(name = "ID")
    val iD: String?,
    @Json(name = "Message")
    val message: String?
)