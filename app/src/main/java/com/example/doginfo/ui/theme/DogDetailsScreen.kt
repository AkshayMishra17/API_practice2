package com.example.doginfo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun DogDetailsScreen(dogImageUrl: String) {
    val decodedUrl = URLDecoder.decode(dogImageUrl, StandardCharsets.UTF_8.toString())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = decodedUrl,
            contentDescription = "Dog Image",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Crop
        )
       Text("No text")
    }

}