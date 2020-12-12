package com.pareandroid.kotlinmovie.Presenter

import com.pareandroid.kotlinmovie.Api.HomeDataSource
import com.pareandroid.kotlinmovie.Api.config
import com.pareandroid.kotlinmovie.Model.HomeResponse
import com.pareandroid.kotlinmovie.View.HomeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view : HomeView) {

    fun  dicovermovie(){
        view.Onshowloading()

        val datasource = config.providesHttpAdapter().create(HomeDataSource::class.java)
        datasource.discoverMovie().enqueue(object: Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.Onhideloading()
                view.OnResponse(response.body()?.results?: emptyList())

            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.Onhideloading()
                view.onFailure(t)
            }

        })
    }
}