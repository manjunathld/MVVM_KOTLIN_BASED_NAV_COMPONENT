package com.example.mvvm_kotlin_based_nav_component.model

import com.example.mvvm_kotlin_based_nav_component.CONSTANTS
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {

    @GET(CONSTANTS.PATH_PUBLISH_HOLIDAY)
    fun getCountries(): Call<List<CountryModelResponse>>

}