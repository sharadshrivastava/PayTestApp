package com.test.myapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.test.myapplication.data.AppRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    fun weatherByCity(cityName: String) = liveData(Dispatchers.IO) {
        emit(AppRepository.weatherByCity(cityName))
    }
}