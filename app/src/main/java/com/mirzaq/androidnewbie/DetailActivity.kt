package com.mirzaq.androidnewbie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BORN = "extra_born"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_FAV = "extra_fav"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val name = intent.getStringExtra(EXTRA_NAME)
        val born = intent.getStringExtra(EXTRA_BORN)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        var fav = intent.getBooleanExtra(EXTRA_FAV, false)

        val tvName: TextView = findViewById(R.id.tv_title)
        val tvBorn: TextView = findViewById(R.id.tv_born)
        val tvDetail: TextView = findViewById(R.id.tv_detail)
        val ivImage: ImageView = findViewById(R.id.iv_image)
        val ivFav: MaterialButton = findViewById(R.id.fav_btn)

        tvName.text = name
        tvBorn.text = born
        tvDetail.text = detail
        ivImage.setImageResource(image)
        ivFav.setOnClickListener(){
            if(fav){
                Toast.makeText(this, "Removed from favorite", Toast.LENGTH_SHORT).show()
                ivFav.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
                ivFav.setIconTintResource(R.color.white)
                ivFav.text = resources.getString(R.string.favorite)
            }else{
                Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
                ivFav.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
                ivFav.setIconTintResource(R.color.red)
                ivFav.text = resources.getString(R.string.unfavorite)
            }
            fav = !fav
        }
        supportActionBar?.title = name
    }
}