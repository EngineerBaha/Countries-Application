package com.example.countriesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.countriesapp.model.Country
import com.example.countriesapp.repo.CountryDaoRepository

class AnasayfaViewModel( application: Application) : AndroidViewModel(application) {

    /*
    var nrepo = NoteDaoRepository(application)
    var noteListesi = MutableLiveData<List<Notes>>()
     */

    var crepo = CountryDaoRepository()

    var countryList = MutableLiveData<List<Country>>()

    init {
        crepo.download(application)
        countryList=crepo.countryList
    }

    fun takeAllCountries(): List<Country>? {
        return countryList.value!!
    }
}