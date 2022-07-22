package com.recyclerview.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * @Author: Abdul Rehman
 * @Date: 22/07/2022.
 */

class AnimalsAdapter(
    val animalsList: ArrayList<String>,
    val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = animalsList[position]
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(animalsList[position])
        }
    }

    override fun getItemCount(): Int {
        return animalsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.title)
    }

    interface OnItemClickListener {
        fun onItemClick(animalName: String)
    }
}