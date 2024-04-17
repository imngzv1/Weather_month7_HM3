package com.example.weather_month7.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_month7.data.model.WeatherModel
import com.example.weather_month7.domain.Repository

class MainViewModel(private val repository: Repository):ViewModel() {
    fun getCurrentTempVM(city:String):LiveData<WeatherModel>{
        return repository.getCurrentTemp(city)
    }
}