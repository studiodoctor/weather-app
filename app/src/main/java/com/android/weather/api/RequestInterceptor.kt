package com.android.weather.api

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor:Interceptor {
     override fun intercept(chain: Interceptor.Chain):Response{


         val originalRequest = chain.request()
             .newBuilder()
             .addHeader("x-rapidapi-key", "b36b934b4emsh844ea897ebea774p1083a2jsn9d310fac3fd6")
             .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
             .build()

        return chain.proceed(originalRequest)
    }
}