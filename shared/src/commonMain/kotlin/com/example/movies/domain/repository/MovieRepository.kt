package com.example.movies.domain.repository

import com.example.movies.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}