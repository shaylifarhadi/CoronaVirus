package com.example.coronavs.network.datamodel


import com.squareup.moshi.Json

data class Global(
    @Json(name = "Date")
    val date: String?,
    @Json(name = "NewConfirmed")
    val newConfirmed: Int?,
    @Json(name = "NewDeaths")
    val newDeaths: Int?,
    @Json(name = "NewRecovered")
    val newRecovered: Int?,
    @Json(name = "TotalConfirmed")
    val totalConfirmed: Int?,
    @Json(name = "TotalDeaths")
    val totalDeaths: Int?,
    @Json(name = "TotalRecovered")
    val totalRecovered: Int?
)