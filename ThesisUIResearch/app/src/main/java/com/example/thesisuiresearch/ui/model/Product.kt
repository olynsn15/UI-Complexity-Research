package com.example.thesisuiresearch.ui.model

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val store: String,
    val price: Int,
    val rating: Double,
    val sold: Int,
    val location: String,
    val stockStatus: String
)
