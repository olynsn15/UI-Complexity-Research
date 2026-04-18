package com.example.thesisuiresearch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesisuiresearch.R
import com.example.thesisuiresearch.ui.adapters.Variant1Adapter
import com.example.thesisuiresearch.ui.adapters.Variant2Adapter
import com.example.thesisuiresearch.ui.adapters.Variant3Adapter

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val variant = intent.getIntExtra("variant", 1)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = DatabaseHelper(this).getProducts()

        val adapter = when(variant) {
            1 -> Variant1Adapter(data)
            2 -> Variant2Adapter(data)
            else -> Variant3Adapter(data)
        }

        recyclerView.adapter = adapter
    }
}