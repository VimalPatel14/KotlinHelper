package com.vimal.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vimal.myapplication.R
import com.vimal.myapplication.retrofitmvvm.RetrofitMVVMActivity
import com.vimal.myapplication.roomdb.RoomDBActivity

class MainActivity : AppCompatActivity() {

    lateinit var hello: Button
    lateinit var forloop: Button
    lateinit var recyclerview_btn: Button
    lateinit var recyclerview_pagination: Button
    lateinit var fragment: Button
    lateinit var fragment_pass_data: Button
    lateinit var retrofit_api: Button
    lateinit var pick_image: Button
    lateinit var image_processing: Button
    lateinit var room_db: Button

    val s1 = "abc"
    val s2 = "Abc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello = findViewById(R.id.hello)
        forloop = findViewById(R.id.forloop)
        recyclerview_btn = findViewById(R.id.recyclerview_btn)
        recyclerview_pagination = findViewById(R.id.recyclerview_pagination)
        fragment = findViewById(R.id.fragment)
        fragment_pass_data = findViewById(R.id.fragment_pass_data)
        retrofit_api = findViewById(R.id.retrofit_api)
        pick_image = findViewById(R.id.pick_image)
        image_processing = findViewById(R.id.image_processing)
        room_db = findViewById(R.id.room_db)

        // Month()

        hello.setOnClickListener {
//            PassIntent("Vimal")
            Month()
        }
        //ArraysExample()

        recyclerview_btn.setOnClickListener {
            val intent = Intent(this, RecyclerviewActivity::class.java)
            startActivity(intent)
        }

        recyclerview_pagination.setOnClickListener {
            val intent = Intent(this, RecyclerViewWithPaginationActivity::class.java)
            startActivity(intent)
        }

        fragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
        fragment_pass_data.setOnClickListener {
            val intent = Intent(this, FragmentPassDataActivity::class.java)
            startActivity(intent)
        }

        retrofit_api.setOnClickListener {
            val intent = Intent(this, RetrofitMVVMActivity::class.java)
            startActivity(intent)
        }
        pick_image.setOnClickListener {
            val intent = Intent(this, PickImageActivity::class.java)
            startActivity(intent)
        }

        image_processing . setOnClickListener {
            val intent = Intent(this, ImageProcessingActivity::class.java)
            startActivity(intent)
        }

        room_db . setOnClickListener {
            val intent = Intent(this, RoomDBActivity::class.java)
            startActivity(intent)
        }

    }

    private fun PassIntent(value: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", "Vimal")
        startActivity(intent)
    }

    companion object {

        fun getValue(): String {

            return "Test String"

        }

        fun Month() {
            var monthNum = (Math.random() * 12).toInt() + 1
            var monthName = when (monthNum) {
                1 -> "January"
                2 -> "February"
                3 -> "March"
                4 -> "April"
                5 -> "May"
                6 -> "June"
                7 -> "July"
                8 -> "August"
                9 -> "September"
                10 -> "October"
                11 -> "November"
                12 -> "December"
                else -> ""
            }

            println(monthName)
        }
    }


    public fun ArraysExample() {
        print("for (i in 1..5) print(i) = ")
        for (i in 1..5) Log.e("vml", i.toString())


        println()

        print("for (i in 5..1) print(i) = ")
        for (i in 5..1) Log.e("vml", i.toString())             // prints nothing

        println()

        print("for (i in 5 downTo 1) print(i) = ")
        for (i in 5 downTo 1) Log.e("vml", i.toString())

        println()

        print("for (i in 1..5 step 2) print(i) = ")
        for (i in 1..5 step 2) Log.e("vml", i.toString())

        println()

        print("for (i in 5 downTo 1 step 2) print(i) = ")
        for (i in 5 downTo 1 step 2) Log.e("vml", i.toString())

        forloop.setOnClickListener {
            if (s1.equals(s2, true)) {
                Log.e("vml", "Equal")
//                println("Equal")
            } else {
                Log.e("vml", "Not Equal")
//                println("Not Equal")
            }
        }
    }


}