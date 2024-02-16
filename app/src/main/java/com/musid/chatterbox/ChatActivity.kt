package com.musid.chatterbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ChatActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private lateinit var messagesRecyclerView: RecyclerView
    private lateinit var sendMessageButton: Button
    private lateinit var messageEditText: EditText
    private val adapter = MessagesAdapter()

    private val messagesList = mutableListOf<Message>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        messagesRecyclerView = findViewById(R.id.recyclerViewMessages)
        sendMessageButton = findViewById(R.id.buttonSend)
        messageEditText = findViewById(R.id.editTextMessage)

        messagesRecyclerView.layoutManager = LinearLayoutManager(this)
        messagesRecyclerView.adapter = adapter // Set the adapter

        listenForMessages()


    }

    private fun sendMessageToFirestore(messageText: String) {
        // Create a message object, assuming you have a Message data class
        val message = Message(
            text = messageText,
            fromId = "user1", // You would replace these with actual user IDs
            toId = "user2",
            timestamp = System.currentTimeMillis()
        )

        // Add message to Firestore
        db.collection("messages").add(message)
            .addOnSuccessListener {
                // Message sent successfully
                // Optionally clear the input field here
            }
            .addOnFailureListener {
                // Handle failure
                it.printStackTrace()
            }
    }


    private fun listenForMessages() {
        // Example Firestore query (you'll need to replace this with your actual Firestore query logic)
        val messages = mutableListOf<Message>() // Placeholder for fetched messages
        // Simulate fetching messages
        messages.add(Message( "Hello!", "user1", "user2", System.currentTimeMillis()))
        messages.add(Message( "Hi there!", "user2", "user1", System.currentTimeMillis()))

        adapter.submitList(messages) // Submit list to the adapter
    }




}