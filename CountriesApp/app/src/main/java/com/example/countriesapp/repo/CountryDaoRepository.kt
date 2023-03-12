package com.example.countriesapp.repo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.countriesapp.model.Country
import com.example.countriesapp.service.CountryAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountryDaoRepository {

    val countryAPIService = CountryAPIService()
    var countryList = MutableLiveData<List<Country>>()





    @SuppressLint("CheckResult")
    fun download(context:Context){

        countryAPIService.getData()
            .subscribeOn(Schedulers.io()) // Arka planda çalıştırma
            .observeOn(AndroidSchedulers.mainThread()) // Ana iş parçacığında sonuçları gösterme
            .subscribe({ countries ->
                // Veriler başarıyla çekildiğinde yapılacak işlemler
                // Örneğin, RecyclerView içerisinde verileri gösterme
                countryList.value = countries


            }, { error ->
                // Hata durumunda yapılacak işlemler
                Toast.makeText(context, "Veriler çekilirken bir hata oluştu: ${error.message}", Toast.LENGTH_SHORT).show()

            })

    }

}