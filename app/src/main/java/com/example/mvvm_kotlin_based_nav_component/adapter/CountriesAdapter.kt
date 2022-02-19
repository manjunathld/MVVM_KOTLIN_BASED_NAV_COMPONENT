package com.example.mvvm_kotlin_based_nav_component.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_based_nav_component.R
import com.example.mvvm_kotlin_based_nav_component.model.CountryModelResponse

class CountriesAdapter(
    listCountryModelResponse: List<CountryModelResponse>,
    countriesViewHolderListener: CountriesViewHolderListener
    ) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private lateinit var listCountryModelResponse: List<CountryModelResponse>
    private lateinit var countriesViewHolderListener: CountriesViewHolderListener

    init {
        this.listCountryModelResponse = listCountryModelResponse
        this.countriesViewHolderListener = countriesViewHolderListener
    }

    class CountriesViewHolder(countriesItemView: View)
        : RecyclerView.ViewHolder(countriesItemView) {
            private val tv_country_id: TextView = countriesItemView.findViewById(R.id.tv_countries_id)
            private val tv_country_name: TextView = countriesItemView.findViewById(R.id.tv_countries_name)
            private val tv_country_date: TextView = countriesItemView.findViewById(R.id.tv_countries_date)

            fun bindData(countryModelResponse: CountryModelResponse) {
                tv_country_id.text = countryModelResponse.countryID
                tv_country_name.text = countryModelResponse.countryName
                tv_country_date.text = countryModelResponse.countryDate
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val countriesRowItem: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.countries_row_item_recyclerview, parent, false)

        return CountriesViewHolder(countriesRowItem)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bindData(listCountryModelResponse[position])
        holder.itemView.setOnClickListener(View.OnClickListener {
            countriesViewHolderListener.onItemClick(holder)
        })
    }

    override fun getItemCount(): Int {
        return if (listCountryModelResponse.isNotEmpty()) {
            listCountryModelResponse.size
        } else { 0 }
    }

    public interface CountriesViewHolderListener {
        fun onItemClick(countriesViewHolder: CountriesViewHolder)
    }

}