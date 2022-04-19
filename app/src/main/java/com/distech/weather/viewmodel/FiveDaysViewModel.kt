package com.distech.weather.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.distech.weather.api.WeatherAPIClient
import com.distech.weather.model.ForecastResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Manpreet Singh on 2021-02-29
 */

class FiveDaysViewModel(application: Application) : AndroidViewModel(application) {

    // val currentLocationData by lazy { MutableLiveData<WeatherResponse>() }

    private val apiClient = WeatherAPIClient()
    private val disposable = CompositeDisposable()

    val forecastData = MutableLiveData<List<ForecastResponse.Forecast>>()
    var forecastDataList : List<ForecastResponse.Forecast> = ArrayList()
    val fiveDaysLoading = MutableLiveData<Boolean>()

    fun getForecastFromGps(latitude: String, longitude: String, units: String) {
        fiveDaysLoading.value = true
        disposable.add(
            apiClient.getForecastFromGps(latitude, longitude, units)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ForecastResponse>() {
                    override fun onSuccess(t: ForecastResponse) {
                        var forecastResponse = t
                        forecastDataList = forecastResponse.list!!
                        forecastData.value = forecastDataList
                        fiveDaysLoading.value = false
                        Log.i("FiveDays : ", "Location Found!!")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("FiveDays : ", "No Location Found : " + e.message + " " + e.printStackTrace())

                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}