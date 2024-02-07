package com.example.movies.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "5wwpo22034b35c2e5cd9014c1dc2aca0394oe"

internal abstract class KtoApi {

    val client = HttpClient {
      install(ContentNegotiation){
          json(Json{
              ignoreUnknownKeys = true
              useAlternativeNames =false
          })
      }
    }

    fun HttpRequestBuilder.pathUrl(path :String){
        url{
            takeFrom(BASE_URL)
            path("3",path)
            parameter("api_key", API_KEY)
        }
    }
}