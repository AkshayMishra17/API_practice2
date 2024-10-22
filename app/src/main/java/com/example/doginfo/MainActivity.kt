package com.example.doginfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.doginfo.model.DogListIntent
import com.example.doginfo.ui.theme.DogListScreen
import com.example.doginfo.viewmodel.DogListViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doginfo.ui.theme.DogDetailsScreen

class MainActivity : ComponentActivity() {
    private val viewModel: DogListViewModel by viewModels() // Use the viewModels delegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Set up the navigation with a NavController
            val navController = rememberNavController()

            // Handle intent inside the composable
            viewModel.handleIntent(DogListIntent.FetchDogs)

            // Navigation setup
            NavHost(navController = navController, startDestination = "dogList") {
                composable("dogList") {
                    DogListScreen(viewModel, navController) // Pass navController to the screen
                }
                composable("dogDetails/{dogImageUrl}") { backStackEntry ->
                    val dogImageUrl = backStackEntry.arguments?.getString("dogImageUrl")
                    dogImageUrl?.let {
                        DogDetailsScreen(dogImageUrl = it)
                    }
                }
            }
        }
    }
}


