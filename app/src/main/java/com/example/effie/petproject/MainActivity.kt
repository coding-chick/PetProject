package com.example.effie.petproject

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.effie.petproject.View.SearchPetsAdapter
import com.example.effie.petproject.ViewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //  message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //   message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //     message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

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

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        model.searchPets()
    }
}
