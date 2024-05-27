package com.example.test_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_project.domain.model.MoviesData
import com.example.test_project.presentation.movies_listings.MoviesList
import com.example.test_project.presentation.movies_listings.MoviesViewModel
import com.example.test_project.ui.theme.TestProjectTheme
import com.example.test_project.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val viewModel: MoviesViewModel = hiltViewModel()
                    viewModel.fetchMovies()
                    val data by remember { viewModel.movieList }.collectAsState()
                    when (data) {
                        is Resource.Loading -> {
                            CircularProgressIndicator()
                        }
                        is Resource.Failure -> {
                            Text(text = "Sorry! Something went wrong")
                        }
                        is Resource.Success -> {
                            val result = (data as Resource.Success<MoviesData>).result.movies
                            MoviesList(movies = result)
                        }
                    }
                }
            }
        }
    }
}
