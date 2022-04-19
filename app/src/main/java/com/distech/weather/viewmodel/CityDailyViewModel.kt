package com.distech.weather.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.distech.weather.api.WeatherAPIClient
import com.distech.weather.model.CityDailyResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Manpreet Singh on 2021-02-29
 */

class CityDailyViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = WeatherAPIClient()
    private val disposable = CompositeDisposable()

    val cityDailyData = MutableLiveData<List<CityDailyResponse.Forecast>>()
    var cityDailyDataList: List<CityDailyResponse.Forecast> = ArrayList()
    val cityDailyLoading = MutableLiveData<Boolean>()

    fun getCityDailyWeatherFromGps(latitude: String, longitude: String, cnt: String, units: String) {
        cityDailyLoading.value = true
        disposable.add(
            apiClient.getCityDailyWeatherFromGps(latitude, longitude, cnt, units)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CityDailyResponse>() {
                    override fun onSuccess(t: CityDailyResponse) {
                        var cityDailyResponse = t
                        cityDailyDataList = cityDailyResponse.list!!
                        cityDailyData.value = cityDailyDataList
                        cityDailyLoading.value = false
                        Log.i("CityDaily : ", "Location Found!!")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("CityDaily : ", "No Location Found : " + e.message + " " + e.printStackTrace())
                    }

                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}