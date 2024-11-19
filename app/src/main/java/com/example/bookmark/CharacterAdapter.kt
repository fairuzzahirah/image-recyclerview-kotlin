package com.example.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(private val characters: List<MainModel>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        // Inflate the layout for each item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        // Get the character at the current position
        val character = characters[position]

        // Bind the character data to the views
        holder.nameTextView.text = character.name
        Glide.with(holder.imageView.context)
            .load(character.imageUrl) // Load image from URL
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        // Return the size of the data list
        return characters.size
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define the views inside each item
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
    }
}
