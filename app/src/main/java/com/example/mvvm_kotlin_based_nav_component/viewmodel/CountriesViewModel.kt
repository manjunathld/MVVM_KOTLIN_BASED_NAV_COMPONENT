package com.example.mvvm_kotlin_based_nav_component.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_kotlin_based_nav_component.model.CountriesService
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelError
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class CountriesViewModel() : ViewModel() {

    private lateinit var countriesMutableLiveDataResponse: MutableLiveData<List<CountryModelResponse>>
    private lateinit var countriesMutableLiveDataError: MutableLiveData<CountryModelError>

    init {
        countriesMutableLiveDataResponse = MutableLiveData<List<CountryModelResponse>>()
        countriesMutableLiveDataError = MutableLiveData<CountryModelError>()
    }

    fun getCountriesMutableLiveDataResponse(): MutableLiveData<List<CountryModelResponse>> {
        return countriesMutableLiveDataResponse
    }

    fun getCountriesMutableLiveDataError(): MutableLiveData<CountryModelError> {
        return countriesMutableLiveDataError
    }

}