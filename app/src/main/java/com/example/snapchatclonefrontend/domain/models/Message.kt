package com.example.snapchatclonefrontend.domain.models

import java.util.*

data class Message(
    val id: String? = null,
    val sender: String? = null,
    val recipient: String? = null,
    val text: String? = null,
    val timestamp: Date? = null
)
