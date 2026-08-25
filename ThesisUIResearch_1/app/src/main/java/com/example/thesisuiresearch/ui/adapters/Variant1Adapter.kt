package com.example.thesisuiresearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisuiresearch.R
import com.example.thesisuiresearch.ui.model.Product

class Variant1Adapter(private val list: List<Product>) : RecyclerView.Adapter<Variant1Adapter.VHolder>() {
    class VHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvProductName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_variant1, parent, false)
        return VHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.name.text = list[position].name
    }
}