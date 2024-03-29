package com.example.movies.android
import android.app.Application
import com.example.movies.android.di.appModule
import com.example.movies.di.getSharedModules
import org.koin.core.context.startKoin

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}