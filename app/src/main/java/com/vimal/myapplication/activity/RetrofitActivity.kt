package com.vimal.myapplication.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vimal.myapplication.R
import com.vimal.myapplication.databinding.ActivityMainBinding
import com.vimal.myapplication.retrofitapi.MainRepository
import com.vimal.myapplication.retrofitapi.MainViewModel
import com.vimal.myapplication.retrofitapi.MyViewModelFactory
import com.vimal.myapplication.retrofitapi.RetrofitService
import com.vimal.myapplication.retrofitapi.adapter.MainAdapter

class RetrofitActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel
    lateinit var recyclerview: RecyclerView

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        recyclerview = findViewById(R.id.recyclerview)
        //get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        //set recyclerview adapter
        recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getAllMovies()
    }
}