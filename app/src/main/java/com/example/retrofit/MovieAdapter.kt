package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*

class MovieAdapter(val context: Context , val movieList: MutableList<Movie>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.image_movie
        val txt_name: TextView = itemView.txt_name
        val txt_team: TextView = itemView.txt_team
        val txt_createdby: TextView = itemView.txt_createdby

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]

        Glide.with(context)
            .load(listItem.imageurl)
            .into(holder.image)

        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_createdby.text = movieList[position].createdby
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}