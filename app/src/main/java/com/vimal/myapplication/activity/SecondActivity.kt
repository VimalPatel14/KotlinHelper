package com.vimal.myapplication.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vimal.myapplication.R


class SecondActivity : AppCompatActivity() {

    lateinit var second: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        second = findViewById(R.id.second)
        val intent = intent

        if (intent.hasExtra("name")) {
            val profileName = intent.getStringExtra("name")
            second.text = profileName
        } else {
            // Do something else
            Toast.makeText(this, "Intent Null", Toast.LENGTH_SHORT).show()
        }
    }
}