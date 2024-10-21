package com.example.doginfo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.doginfo.model.DogImageResponse
import com.example.doginfo.model.DogListState
import com.example.doginfo.viewmodel.DogListViewModel

@Composable
fun DogListScreen(viewModel: DogListViewModel) {
    val state by viewModel.state.collectAsState()

    when (state) {
        is DogListState.Loading -> {
            LoadingView()
        }
        is DogListState.Success -> {
            val dogs = (state as DogListState.Success).dogs
            DogListView(dogs = dogs)
        }
        is DogListState.Error -> {
            val error = (state as DogListState.Error).error
            ErrorView(error) // Pass the error message
        }
    }
}

@Composable
fun LoadingView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(error: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = error, color = MaterialTheme.colorScheme.error)
    }
}

@Composable
fun DogItem(dog: DogImageResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
         // elevation = 4.dp
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = dog.url),
            contentDescription = "Dog Image",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DogListView(dogs: List<DogImageResponse>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 50.dp)) {
        items(dogs) { dog ->
            DogItem(dog = dog)
        }
    }
}
