package com.example.mvvm_kotlin_based_nav_component.model

import com.google.gson.annotations.SerializedName

data class CountryModelResponse
    (
        @SerializedName("countryCode")
        val countryID: String,
        @SerializedName("name")
        val countryName: String,
        @SerializedName("date")
        val countryDate: String
    )
