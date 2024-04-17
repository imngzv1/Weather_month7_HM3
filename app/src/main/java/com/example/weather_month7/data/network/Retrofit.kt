package com.example.weather_month7.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    val retrofit = Retrofit.Builder().baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val api=retrofit.create(WeatherApi::class.java)
}