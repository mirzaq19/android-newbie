package com.mirzaq.androidnewbie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvScientist: RecyclerView
    private var list: ArrayList<Scientist> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Scientist List"
        rvScientist = findViewById(R.id.rv_list)
        rvScientist.setHasFixedSize(true)

        list.addAll(ScientistData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvScientist.layoutManager = LinearLayoutManager(this)
        rvScientist.adapter = ListScientistAdapter(list)
    }
}