package com.example.mvvm_kotlin_based_nav_component.model

import com.example.mvvm_kotlin_based_nav_component.CONSTANTS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesService() {

    private lateinit var countriesAPI: CountriesAPI

    init {
        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(CONSTANTS.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        countriesAPI = retrofit.create(CountriesAPI::class.java)
    }

    public fun getCountries(): Call<List<CountryModel>> {
        return countriesAPI.getCountries()
    }

}