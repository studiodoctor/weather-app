package com.distech.weather.api

import com.distech.weather.model.CityDailyResponse
import com.distech.weather.model.ForecastResponse
import com.distech.weather.model.WeatherResponse
import com.distech.weather.util.Constant
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Manpreet Singh on 2021-02-29
 */

class WeatherAPIClient {

    private val api = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkHttpClient())
        .build()
        .create(WeatherAPI::class.java)

    fun getDataFromGps(
        latitude: String,
        longitude: String,
        units: String
    ): Single<WeatherResponse> {
        return api.getWeatherByGPS(latitude, longitude, units)
    }

    fun getForecastFromGps(
        latitude: String,
        longitude: String,
        units: String
    ): Single<ForecastResponse> {
        return api.getForecastByGPS(latitude, longitude, units)
    }

    fun getCityDailyWeatherFromGps(
        latitude: String,
        longitude: String,
        cnt: String,
        units: String
    ): Single<CityDailyResponse> {
        return api.getCityDailyWeatherByGPS(latitude, longitude, cnt, units)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor())
        return client.build()
    }

}