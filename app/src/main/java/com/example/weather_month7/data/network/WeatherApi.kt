package com.example.weather_month7.data.network

import com.example.weather_month7.data.model.WeatherModel
import com.squareup.picasso.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("forecast.json")
    fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 1,
        @Query("aqi") includeAqi: String = "no",
        @Query("alerts") includeAlerts: String = "no"
    ): Call<WeatherModel>
}