package com.vimal.myapplication.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vimal.myapplication.R
import com.vimal.myapplication.adapter.CustomAdapter
import com.vimal.myapplication.interfaces.CellClickListener

class RecyclerviewActivity : AppCompatActivity(), CellClickListener {

    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var add : Button
    var value : Int =1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        title = "RecyclerView - www.tutorialkart.com"

        add = findViewById(R.id.add)
        recyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()

        add.setOnClickListener{
            Log.e("vml","AddItems_Click")
            AddItems();
        }
    }

    private fun prepareItems() {
        for (i in 1..10) itemsList.add(value.toString()+" Item "+i)
//        Collections.reverse(itemsList)
//        itemsList.add("Item 1")
//        itemsList.add("Item 2")
//        itemsList.add("Item 3")
//        itemsList.add("Item 4")
//        itemsList.add("Item 5")
//        itemsList.add("Item 6")
//        itemsList.add("Item 7")
//        itemsList.add("Item 8")
//        itemsList.add("Item 9")
//        itemsList.add("Item 10")
        customAdapter.notifyDataSetChanged()
    }

    private fun AddItems() {
        Log.e("vml","AddItems")
        value = value+1;
        for (i in 1..10) itemsList.add(value.toString()+" Item "+i)
        customAdapter.notifyDataSetChanged()
//        for (i in 1..10) itemsList.add("Item "+i)
    }

    override fun onCellClickListener(editTextInput: String,pos: Int) {
        val str1 = editTextInput;
        val str2 = pos.toString();
        Log.e("vml",str1+" String");
        Log.e("vml",str2+" pos");
        Toast.makeText(this,editTextInput+" Pos "+pos.toString(), Toast.LENGTH_SHORT).show()
    }
}