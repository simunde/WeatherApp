package com.musid.chatterbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var contactsRecyclerView: RecyclerView
    private val contactsList = listOf("Contact 1", "Contact 2") // Placeholder data



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        contactsRecyclerView = findViewById(R.id.recyclerViewContacts)
        contactsRecyclerView.layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.adapter = ContactsAdapter(contactsList) { contactName ->
            // Handle contact click, navigate to ChatActivity
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)




        }
    }
}