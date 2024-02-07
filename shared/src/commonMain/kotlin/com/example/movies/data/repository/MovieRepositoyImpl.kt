package com.example.movies.data.repository

import com.example.movies.data.remote.RemoteDataSource
import com.example.movies.data.util.toMovie
import com.example.movies.domain.model.Movie
import com.example.movies.domain.repository.MovieRepository

internal class MovieRepositoyImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId).toMovie()
    }

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page).results.map {
            it.toMovie()
        }
    }
}