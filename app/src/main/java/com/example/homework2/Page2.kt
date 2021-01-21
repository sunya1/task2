package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Page2 : AppCompatActivity() {
    private lateinit var recycler_view: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        recycler_view = findViewById(R.id.recycler_view)
        val list = intent.getParcelableArrayListExtra<Parcelable>("list") as ArrayList<Student>
        Log.d("listof" , intent.extras.toString())
        recycler_view.adapter = RecyclerAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
}