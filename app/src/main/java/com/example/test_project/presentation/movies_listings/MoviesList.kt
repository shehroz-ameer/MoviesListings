package com.example.test_project.presentation.movies_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.test_project.domain.model.Movie

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie = movie)
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
    ) {
        Row {
            Image(
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w500${movie.posterPath}"),
                contentDescription = null,
                modifier =
                    Modifier
                        .padding(8.dp)
                        .width(100.dp)
                        .height(300.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .align(Alignment.CenterVertically),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = movie.name,
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Magenta),
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 8.dp),
                )
            }
        }
    }
}
