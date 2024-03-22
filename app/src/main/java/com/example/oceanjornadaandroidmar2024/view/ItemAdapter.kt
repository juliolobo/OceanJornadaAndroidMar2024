package com.example.oceanjornadaandroidmar2024.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.oceanjornadaandroidmar2024.model.domain.Item
import com.example.oceanjornadaandroidmar2024.R

class ItemAdapter(val itens: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Item) {
            val textView = itemView.findViewById<TextView>(R.id.textView)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)

            textView.text = item.nome
            Glide.with(imageView).load(item.imagem).into(imageView)

            itemView.setOnClickListener {
                val itemDetailIntent = Intent(itemView.context, ItemDetailActivity::class.java)
                itemDetailIntent.putExtra("ID", item.id)
                itemView.context.startActivity(itemDetailIntent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.bindView(item)
    }
}
