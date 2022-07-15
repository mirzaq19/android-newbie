package com.mirzaq.androidnewbie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        val listScientistAdapter = ListScientistAdapter(list)
        rvScientist.adapter = listScientistAdapter

        listScientistAdapter.setOnItemClickCallback(object : ListScientistAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Scientist) {
                Toast.makeText(this@MainActivity, "You selected " + data.name, Toast.LENGTH_SHORT).show()
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveIntent.putExtra(DetailActivity.EXTRA_NAME, data.name)
                moveIntent.putExtra(DetailActivity.EXTRA_DETAIL, data.detail)
                moveIntent.putExtra(DetailActivity.EXTRA_BORN, data.born)
                moveIntent.putExtra(DetailActivity.EXTRA_IMAGE, data.image)
                startActivity(moveIntent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.btn_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}