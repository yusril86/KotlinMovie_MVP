package com.pareandroid.kotlinmovie.Api

import com.pareandroid.kotlinmovie.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object config {

    fun providesHttpAdapter(): Retrofit {
        return Retrofit.Builder().apply {
            client(providesHttpClient())
            baseUrl(BuildConfig.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    private fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(providesHttpLoggingInterCeptor())
        }.build()
    }

    private fun providesHttpLoggingInterCeptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG){
                true -> Level.BODY
                false -> Level.NONE
            }
        }
    }

}