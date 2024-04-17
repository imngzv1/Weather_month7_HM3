package com.example.weather_month7.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weather_month7.data.model.WeatherModel
import com.example.weather_month7.data.network.WeatherApi
import com.example.weather_month7.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Response
import kotlin.math.roundToInt

class Repository(private val api: WeatherApi) {

    fun getCurrentTemp(city:String):LiveData<WeatherModel>{
        val dataTemp=MutableLiveData<WeatherModel>()
        api.getCurrentWeather("19684537d9c045958d2200834240704",city).enqueue(object : retrofit2.Callback<WeatherModel> {

            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let {
                    if (response.isSuccessful){
                        dataTemp.value=response.body()
                    }else{
                        Log.e("Repository Error","Repository Error")
                    }
                }
            }
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                Log.e("RepositoryFragment", "Error: ${t.message}")
            }
        })
        return dataTemp
    }
}