package com.example.movies.di

import com.example.movies.data.remote.MovieService
import com.example.movies.data.remote.RemoteDataSource
import com.example.movies.data.repository.MovieRepositoyImpl
import com.example.movies.domain.usecase.GetMovieUseCase
import com.example.movies.domain.usecase.GetMoviesUseCase
import com.example.movies.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(),get()) }
    factory { MovieService() }
}

private val utitlyModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single { MovieRepositoyImpl(get()) }
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utitlyModule)

fun getSharedModules() = sharedModules