package com.example.models

import kotlinx.serialization.Serializable


/**
 * A placeholder for the Response the User will recieve
 */
@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val Designs: List<Design> = emptyList())