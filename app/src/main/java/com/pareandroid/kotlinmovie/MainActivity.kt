package com.pareandroid.kotlinmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pareandroid.kotlinmovie.Api.HomeDataSource
import com.pareandroid.kotlinmovie.Model.HomeResponse
import com.pareandroid.kotlinmovie.Api.config
import com.pareandroid.kotlinmovie.Model.Result
import com.pareandroid.kotlinmovie.Presenter.HomePresenter
import com.pareandroid.kotlinmovie.View.HomeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(),HomeView {
    private lateinit var progressBar :ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         progressBar = findViewById<ProgressBar>(R.id.pb_home)
         recyclerView = findViewById<RecyclerView>(R.id.rv_home)
        val presenter = HomePresenter(this)
        presenter.dicovermovie()








       /* val dataSource = config.providesHttpAdapter().create(HomeDataSource::class.java)
        dataSource.discoverMovie()
            .enqueue(object: Callback<HomeResponse>{
                override fun onResponse(
                    call: Call<HomeResponse>,
                    response: Response<HomeResponse>)
                {
                    progressBar.visibility = View.GONE



                    val results = response.body()?.results
                    val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)

                    itemAdapter.layoutManager = LinearLayoutManager(this@MainActivity)
                    itemAdapter.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                    itemAdapter.adapter = HomeAdapter(results ?: emptyList())
                }

                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                    Log.e(MainActivity::class.java.simpleName, "${t.printStackTrace()}")
                }

            })*/

    }

    override fun Onshowloading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun Onhideloading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun OnResponse(result: List<Result>) {
       recyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
        recyclerView.adapter = HomeAdapter(result)
    }

    override fun onFailure(error: Throwable) {
       Log.e(MainActivity::class.java.simpleName, "${error.printStackTrace()}")
    }
}
