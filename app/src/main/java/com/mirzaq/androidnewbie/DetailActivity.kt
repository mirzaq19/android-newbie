package com.mirzaq.androidnewbie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BORN = "extra_born"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val name = intent.getStringExtra(EXTRA_NAME)
        val born = intent.getStringExtra(EXTRA_BORN)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)

        val tvName: TextView = findViewById(R.id.tv_title)
        val tvBorn: TextView = findViewById(R.id.tv_born)
        val tvDetail: TextView = findViewById(R.id.tv_detail)
        val ivImage: ImageView = findViewById(R.id.iv_image)

        tvName.text = name
        tvBorn.text = born
        tvDetail.text = detail
        ivImage.setImageResource(image)
    }
}