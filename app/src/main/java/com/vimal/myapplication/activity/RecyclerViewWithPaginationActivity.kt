package com.vimal.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vimal.myapplication.R
import com.vimal.myapplication.pagination.GridRecyclerView.GridRecyclerViewActivity
import com.vimal.myapplication.pagination.LinearRecyclerView.LinearRecyclerViewActivity
import com.vimal.myapplication.pagination.StaggeredRecyclerView.StaggeredRecyclerViewActivity

class RecyclerViewWithPaginationActivity : AppCompatActivity() {

    lateinit var linear_rv_btn: Button
    lateinit var grid_rv_btn: Button
    lateinit var staggered_rv_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_pagination)

        linear_rv_btn = findViewById(R.id.linear_rv_btn)
        grid_rv_btn = findViewById(R.id.grid_rv_btn)
        staggered_rv_btn = findViewById(R.id.staggered_rv_btn)

        linear_rv_btn.setOnClickListener {
            val intent = Intent(this,
                LinearRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        grid_rv_btn.setOnClickListener {
            val intent = Intent(this,
                GridRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        staggered_rv_btn.setOnClickListener {
            val intent = Intent(this,
                StaggeredRecyclerViewActivity::class.java)
            startActivity(intent)
        }


    }


}