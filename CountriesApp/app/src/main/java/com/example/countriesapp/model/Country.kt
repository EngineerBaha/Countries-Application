package com.example.countriesapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    @Expose
    val countryName: String?,
    @SerializedName("region")
    @Expose
    val countryRegion: String?,
    @SerializedName("capital")
    @Expose
    val countryCapital: String?,
    @SerializedName("currency")
    @Expose
    val countryCurrency: String?,
    @SerializedName("language")
    @Expose
    val countryLanguage: String?,
    @SerializedName("flag")
    @Expose
    var imageUrl: String?)
