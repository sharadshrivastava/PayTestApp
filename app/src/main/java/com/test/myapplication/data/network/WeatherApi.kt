package com.test.myapplication.data.network

import com.test.app.data.network.model.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(WEATHER_PATH)
    suspend fun weatherByCity(
        @Query("q") query: String,
        @Query("appid") appId: String = APP_ID
    ): Response

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"

        private const val WEATHER_PATH = "data/2.5/weather"
        private const val APP_ID = "95d190a434083879a6398aafd54d9e73"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        fun weatherApi() = retrofit.create(WeatherApi::class.java)
    }
}