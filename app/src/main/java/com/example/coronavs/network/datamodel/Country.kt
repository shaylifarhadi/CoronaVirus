package com.example.coronavs.network.datamodel


import com.squareup.moshi.Json

data class Country(
    @Json(name = "Country")
    val country: String?,
    @Json(name = "CountryCode")
    val countryCode: String?,
    @Json(name = "Date")
    val date: String?,
    @Json(name = "ID")
    val iD: String?,
    @Json(name = "NewConfirmed")
    val newConfirmed: Int?,
    @Json(name = "NewDeaths")
    val newDeaths: Int?,
    @Json(name = "NewRecovered")
    val newRecovered: Int?,
    @Json(name = "Premium")
    val premium: Premium?,
    @Json(name = "Slug")
    val slug: String?,
    @Json(name = "TotalConfirmed")
    val totalConfirmed: Int?,
    @Json(name = "TotalDeaths")
    val totalDeaths: Int?,
    @Json(name = "TotalRecovered")
    val totalRecovered: Int?
)