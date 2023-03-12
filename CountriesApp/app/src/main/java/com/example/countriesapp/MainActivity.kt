package com.example.countriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countriesapp.model.Country
import com.example.countriesapp.ui.theme.CountriesAppTheme
import com.example.countriesapp.view.Anasayfa
import com.example.countriesapp.view.DetaySayfa
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesAppTheme {
                SayfaGecisleri()
            }
        }
    }
}
@Composable
fun SayfaGecisleri(){

val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Anasayfa"){
        composable("Anasayfa") {
            Anasayfa(navController)
        }
        composable("DetaySayfa/{country}", arguments = listOf(
            navArgument("country"){type= NavType.StringType}
        )) {
            val json = it.arguments?.getString("country")!!
            val nesne = Gson().fromJson(json, Country::class.java)
            DetaySayfa(nesne)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountriesAppTheme {

    }
}