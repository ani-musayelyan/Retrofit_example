package com.example.retrofit

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity() : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MovieAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitServices
        recycler_movies.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_movies.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovies()


    }

    fun getAllMovies() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(
                call: Call<MutableList<Movie>>?,
                response: Response<MutableList<Movie>>?
            ) {
                adapter = MovieAdapter(baseContext, response!!.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recycler_movies.adapter = adapter

                dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Movie>>?, t: Throwable?) {
            }

        })

    }

}

