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
fun DetaySayfa(country: Country){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        println("THE IMAGE IS ${country.imageUrl}")
        val painter = rememberImagePainter(data = "https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/${country.imageUrl}")
        val painterstate = painter.state

        Image(painter = rememberImagePainter(data = "https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/${country.imageUrl}"),
            contentDescription = country.countryName,
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp, 160.dp)
        )

        if(painterstate is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "${country.countryName}",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "${country.countryCapital}",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "${country.countryRegion}",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "${country.countryCurrency}",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "${country.countryLanguage}",
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

    }
}

