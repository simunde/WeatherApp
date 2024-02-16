package com.musid.chatterbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val contacts: List<String>,
                      private val onClick: (String) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact, onClick)
    }



    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewContactName)

        fun bind(contactName: String, onClick: (String) -> Unit) {
            nameTextView.text = contactName
            itemView.setOnClickListener { onClick(contactName) }
        }

}}
