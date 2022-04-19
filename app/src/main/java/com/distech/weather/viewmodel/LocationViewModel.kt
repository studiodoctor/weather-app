package com.distech.weather.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.distech.weather.api.WeatherAPIClient
import com.distech.weather.model.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Manpreet Singh on 2021-02-29
 */

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    // val currentLocationData by lazy { MutableLiveData<WeatherResponse>() }

    private val apiClient = WeatherAPIClient()
    private val disposable = CompositeDisposable()

    val locationData = MutableLiveData<WeatherResponse>()
    val locationLoading = MutableLiveData<Boolean>()

    fun getWeatherDataWithGPS(latitude: String, longitude: String, units: String) {
        locationLoading.value = true
        disposable.add(
            apiClient.getDataFromGps(latitude, longitude, units)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<WeatherResponse>() {
                    override fun onSuccess(t: WeatherResponse) {
                        locationData.value = t
                        locationLoading.value = false
                        Log.i("Location : ", "Location Found!!")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("Location : ", "No Location Found : " + e.message + " " + e.printStackTrace())

                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}