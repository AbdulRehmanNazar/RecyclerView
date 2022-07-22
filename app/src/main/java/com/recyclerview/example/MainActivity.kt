package com.recyclerview.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AnimalsAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AnimalsAdapter(generateData(),this)
        recyclerView.adapter = adapter

    }

    fun generateData(): ArrayList<String> {
        val animalList = ArrayList<String>()
        animalList.add("Cat")
        animalList.add("Dog")
        animalList.add("Elephant")
        animalList.add("Zebra")
        animalList.add("Cow")
        animalList.add("Goat")

        return animalList

    }

    override fun onItemClick(animalName: String) {
        Toast.makeText(this@MainActivity, animalName + " clicked", Toast.LENGTH_SHORT).show()
    }
}