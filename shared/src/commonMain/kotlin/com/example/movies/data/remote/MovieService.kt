package com.example.movies.data.remote

import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MovieService: KtorApi() {

    suspend fun getMovies(page: Int = 1): MoviesResponse {
        val response = client.get {
            pathUrl("movie/popular")
            parameter("page", page)
        }.body<MoviesResponse>()
      return  response
    }


    suspend fun getMovie(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}