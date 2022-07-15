package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Design(
    val id : Int,
    val title: String,
    val category:String,
    val image: String,
    val about: String,
    val likes: Int,
    val size: String,
    val color: String
)