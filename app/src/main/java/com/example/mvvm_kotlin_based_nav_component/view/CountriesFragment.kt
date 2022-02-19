package com.example.mvvm_kotlin_based_nav_component.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_based_nav_component.R
import com.example.mvvm_kotlin_based_nav_component.adapter.CountriesAdapter
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelError
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelResponse
import com.example.mvvm_kotlin_based_nav_component.repository.CountriesRepository

class CountriesFragment : Fragment(), CountriesAdapter.CountriesViewHolderListener {

    private lateinit var countriesRepository: CountriesRepository
    private lateinit var listCountryModelResponse: ArrayList<CountryModelResponse>
    private lateinit var countryModelError: CountryModelError
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var rv_countries: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("CountriesFragment","onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CountriesFragment","onCreate")
        listCountryModelResponse = ArrayList<CountryModelResponse>()
        countriesAdapter = CountriesAdapter(listCountryModelResponse, this)
        countriesRepository = CountriesRepository(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("CountriesFragment","onCreateView")
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CountriesFragment","onViewCreated")
        rv_countries = view.findViewById(R.id.rv_Countries)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
        rv_countries.layoutManager = linearLayoutManager
        rv_countries.adapter = countriesAdapter
        observeCountriesViewModel()
    }

    override fun onStart() {
        super.onStart()
        Log.d("CountriesFragment","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CountriesFragment","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CountriesFragment","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CountriesFragment","onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("CountriesFragment","onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CountriesFragment","onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("CountriesFragment","onDetach")
    }

    private fun observeCountriesViewModel() {
        //OnResponse
        val observeCountriesResponse: Observer<List<CountryModelResponse>> =
            Observer<List<CountryModelResponse>>() { listCountryModelResponse ->
                if (listCountryModelResponse.isNotEmpty()) {
                    this.listCountryModelResponse.clear()
                    this.listCountryModelResponse.addAll(listCountryModelResponse)
                    countriesAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(context, "No Dta available", Toast.LENGTH_SHORT).show()
                }
        }

        //OnError
        val observeCountriesError: Observer<CountryModelError> =
            Observer<CountryModelError>() {countryModelError: CountryModelError ->
                this.countryModelError = CountryModelError(countryModelError.countryStatus, countryModelError.countryMessage)
                if (countryModelError.countryStatus) {
                    Toast.makeText(context, countryModelError.countryMessage, Toast.LENGTH_SHORT).show()
                }
        }

        countriesRepository.getCountriesMutableLiveDataResponse().observe(this, observeCountriesResponse)
        countriesRepository.getCountriesMutableLiveDataError().observe(this, observeCountriesError)
    }

    override fun onItemClick(countriesViewHolder: CountriesAdapter.CountriesViewHolder) {
        Toast.makeText(context, ""+listCountryModelResponse[countriesViewHolder.adapterPosition], Toast.LENGTH_SHORT).show()
    }

}