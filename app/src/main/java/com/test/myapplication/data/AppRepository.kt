package com.test.myapplication.data

import com.test.myapplication.data.network.WeatherApi

object AppRepository {

    val api = WeatherApi.weatherApi()

    suspend fun weatherByCity(cityName: String) = api.weatherByCity(cityName)
}