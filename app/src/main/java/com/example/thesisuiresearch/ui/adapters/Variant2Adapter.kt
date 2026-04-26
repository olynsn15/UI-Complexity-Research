package com.example.thesisuiresearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisuiresearch.R
import com.example.thesisuiresearch.ui.model.Product

class Variant2Adapter(private val list: List<Product>) : RecyclerView.Adapter<Variant2Adapter.VHolder>() {
    class VHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvProductName)
        val category: TextView = view.findViewById(R.id.tvCategory)
        val price: TextView = view.findViewById(R.id.tvPrice)
        val stock: TextView = view.findViewById(R.id.tvStock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_variant2, parent, false)
        return VHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val product = list[position]
        holder.name.text = product.name
        holder.category.text = product.category
        holder.price.text = holder.itemView.context.getString(R.string.price_format, product.price)
        holder.stock.text = holder.itemView.context.getString(R.string.stock_format, product.stockStatus)
    }
}