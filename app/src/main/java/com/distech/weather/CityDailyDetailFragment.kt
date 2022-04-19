package com.distech.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.distech.weather.databinding.FragmentOneDayDetailBinding
import com.distech.weather.model.CityDailyResponse

/**
 * Created by Manpreet Singh on 2021-02-29
 */

class CityDailyDetailFragment : Fragment() {

    private lateinit var dataBinding: FragmentOneDayDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_one_day_detail, container, false)
        var cityDailyResponse = arguments?.getParcelable<CityDailyResponse.Forecast>("cityWeatherDetail")
        dataBinding.detail = cityDailyResponse
        return dataBinding.root
    }



}
