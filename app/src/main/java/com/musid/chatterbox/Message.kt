package com.musid.chatterbox

data class Message(
//    val id: String, // Unique identifier for the message
    val text: String, // Text content of the message
    val fromId: String, // Sender's user ID
    val toId: String, // Recipient's user ID
    val timestamp: Long // Time the message was sent
)
