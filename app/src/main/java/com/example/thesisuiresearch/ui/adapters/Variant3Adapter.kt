package com.example.thesisuiresearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisuiresearch.R
import com.example.thesisuiresearch.ui.model.Product

class Variant3Adapter(private val list: List<Product>): RecyclerView.Adapter<Variant3Adapter.VHolder>() {
    class VHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvProductName)
        val category: TextView = view.findViewById(R.id.tvCategory)
        val shop: TextView = view.findViewById(R.id.tvShopName)
        val price: TextView = view.findViewById(R.id.tvPrice)
        val stock: TextView = view.findViewById(R.id.tvStock)
        val rating: TextView = view.findViewById(R.id.tvRating)
        val sold: TextView = view.findViewById(R.id.tvSold)
        val location: TextView = view.findViewById(R.id.tvLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_variant3, parent, false)
        return VHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val product = list[position]
        holder.name.text = product.name
        holder.category.text = product.category
        holder.shop.text = product.store
        holder.price.text = holder.itemView.context.getString(R.string.price_format, product.price)
        holder.stock.text = holder.itemView.context.getString(R.string.stock_format, product.stockStatus)
        holder.rating.text = holder.itemView.context.getString(R.string.rating_format, product.rating)
        holder.sold.text = holder.itemView.context.getString(R.string.sold_format, product.sold)
        holder.location.text = product.location
    }
}