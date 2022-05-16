package com.vimal.myapplication.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.vimal.myapplication.R
import com.vimal.myapplication.helpers.Filter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class ImageProcessingActivity : AppCompatActivity() {

    private val IMAGE_URL =
        "https://raw.githubusercontent.com/DevTides/JetpackDogsApp/master/app/src/main/res/drawable/dog.png"
    private val CouroutinrScope = CoroutineScope(Dispatchers.Main)
    lateinit var progressBar: ProgressBar
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_processing)

        progressBar = findViewById(R.id.progressBar)
        imageView = findViewById(R.id.imageView)

        CouroutinrScope.launch {
            val originalDeferred = CouroutinrScope.async(Dispatchers.IO) { getBitmap() }
            val OriginalBitmap = originalDeferred.await()

            val filterlDeferred = CouroutinrScope.async(Dispatchers.Default) { applyFilter(OriginalBitmap) }
            val filterBitmap = filterlDeferred.await()
            loadimage(filterBitmap)
        }


    }

    private fun getBitmap(): Bitmap =
        URL(IMAGE_URL).openStream().use {
            BitmapFactory.decodeStream(it)
        }

    private fun applyFilter(OriginalBitmap: Bitmap) = Filter.apply(OriginalBitmap)

    private fun loadimage(bmp: Bitmap){
        progressBar.visibility = View.GONE
        imageView.setImageBitmap(bmp)
        imageView.visibility = View.VISIBLE

    }
}