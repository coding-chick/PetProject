package com.example.effie.petproject

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.effie.petproject.View.SearchPetsAdapter
import com.example.effie.petproject.ViewModel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val recyclerViewAdapter = SearchPetsAdapter(model.petsInSearch, this)
        findViewById<RecyclerView>(R.id.search_results).apply {
            layoutManager = viewManager
            adapter = recyclerViewAdapter
        }

        model.searchPets()
    }
}
