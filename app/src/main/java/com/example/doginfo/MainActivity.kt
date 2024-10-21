package com.example.doginfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.doginfo.model.DogListIntent
import com.example.doginfo.ui.theme.DogInfoTheme
import com.example.doginfo.ui.theme.DogListScreen
import com.example.doginfo.viewmodel.DogListViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: DogListViewModel by viewModels() // Use the viewModels delegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Handle intent inside the composable
            viewModel.handleIntent(DogListIntent.FetchDogs)
            DogListScreen(viewModel)
        }
    }
}
