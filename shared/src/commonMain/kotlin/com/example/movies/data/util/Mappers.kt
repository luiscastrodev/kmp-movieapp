package com.example.movies.data.util

import com.example.movies.data.remote.MovieRemote
import com.example.movies.domain.model.Movie


internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImage(porterImage),
        releaseDate = releaseDate
    )
}

private fun getImage(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"