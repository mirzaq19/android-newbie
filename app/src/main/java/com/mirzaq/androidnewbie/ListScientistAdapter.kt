package com.mirzaq.androidnewbie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class ListScientistAdapter(private val scientists: ArrayList<Scientist>) : RecyclerView.Adapter<ListScientistAdapter.ScientistViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ScientistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_item_title)
        var detail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var image: ImageView = itemView.findViewById(R.id.img_item)
        var btnDetail: MaterialButton = itemView.findViewById(R.id.btn_item_detail)
    }

    override fun getItemCount(): Int {
        return scientists.size
    }

    override fun onBindViewHolder(holder: ScientistViewHolder, position: Int) {
        val scientist = scientists[position]
        Glide.with(holder.itemView.context)
            .load(scientist.image)
            .into(holder.image)
        holder.name.text = scientist.name
        holder.detail.text = scientist.detail

        holder.btnDetail.setOnClickListener { onItemClickCallback.onItemClicked(scientist) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScientistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ScientistViewHolder(view)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Scientist)
    }
}