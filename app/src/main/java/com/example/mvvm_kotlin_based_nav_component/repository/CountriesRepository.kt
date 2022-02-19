package com.example.mvvm_kotlin_based_nav_component.repository

import androidx.lifecycle.*
import com.example.mvvm_kotlin_based_nav_component.model.CountriesService
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelError
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelResponse
import com.example.mvvm_kotlin_based_nav_component.viewmodel.CountriesViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesRepository(viewModelStoreOwner: ViewModelStoreOwner) {

    private lateinit var countriesMutableLiveDataResponse: MutableLiveData<List<CountryModelResponse>>
    private lateinit var countriesMutableLiveDataError: MutableLiveData<CountryModelError>
    private lateinit var countriesService: CountriesService
    private lateinit var countriesViewModel: CountriesViewModel

    init {
        countriesViewModel = ViewModelProvider(viewModelStoreOwner).get(CountriesViewModel::class.java)
        countriesMutableLiveDataResponse = countriesViewModel.getCountriesMutableLiveDataResponse()
        countriesMutableLiveDataError = countriesViewModel.getCountriesMutableLiveDataError()
        countriesService = CountriesService()

        fetchCountries()
    }

    fun getCountriesMutableLiveDataResponse(): LiveData<List<CountryModelResponse>> {
        return countriesMutableLiveDataResponse
    }

    fun getCountriesMutableLiveDataError(): LiveData<CountryModelError> {
        return countriesMutableLiveDataError
    }

    private fun fetchCountries() {
        countriesService.getCountries().enqueue(object : Callback<List<CountryModelResponse>> {
            override fun onResponse(
                call: Call<List<CountryModelResponse>>,
                response: Response<List<CountryModelResponse>>
            ) {
                if (response.isSuccessful && response.body()!!.isNotEmpty()) {
                    countriesMutableLiveDataResponse.value = response.body()
                    countriesMutableLiveDataError.value = CountryModelError(false, "")
                } else {
                    countriesMutableLiveDataError.value = CountryModelError(true, "No data found!")
                }
            }

            override fun onFailure(call: Call<List<CountryModelResponse>>, t: Throwable) {
                countriesMutableLiveDataError.value = CountryModelError(true, t.toString())
            }

        })
    }

}