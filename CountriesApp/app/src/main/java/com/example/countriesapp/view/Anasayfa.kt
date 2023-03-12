package com.example.countriesapp.view

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.countriesapp.model.Country
import com.example.countriesapp.viewmodel.AnasayfaViewModel
import com.example.countriesapp.viewmodelfactory.AnasayfaViewModelFactory
import com.google.gson.Gson


@OptIn(ExperimentalCoilApi::class)
@Composable
fun Anasayfa(navController: NavController) {


    val context = LocalContext.current
    val viewmodel: AnasayfaViewModel = viewModel(
        factory = AnasayfaViewModelFactory(context.applicationContext as Application)
    )


    val countries = viewmodel.countryList.observeAsState(listOf())
    /*
    val countries = remember {
        mutableStateListOf<Country>(
            Country("das", "asd,", "dafs", "sadsa", "adssad", "saddasa"),
            Country("sad", "sad,", "sad", "sad", "sad", "sad")

        )
    }
    */

    LazyColumn {
        items(count = countries.value.size, itemContent = {

            val country = countries.value!![it]

            val url = country.imageUrl
            val lastSevenChars = url?.takeLast(7)
            country.imageUrl=lastSevenChars
            //sayfalar arası geçiş
            //val new_country = country
            //new_country.imageUrl=lastSevenChars
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable {



                    val countryJson = Gson().toJson(country)
                    navController.navigate("DetaySayfa/${countryJson}")
                }) {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val painter = rememberImagePainter(data = "https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/${country.imageUrl}")
                        val painterstate = painter.state

                        Image(painter =painter,
                            contentDescription = country.countryName,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(60.dp, 80.dp)
                        )
                        if(painterstate is ImagePainter.State.Loading){
                            CircularProgressIndicator()
                        }

                        Column(
                            modifier = Modifier
                                .width(250.dp)
                                .fillMaxHeight()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {


                            Text(
                                text = "${country.countryName}",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.padding(vertical = 6.dp))
                            Text(
                                text = "${country.countryRegion}",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }


                }


            }
        })


    }


}

