package com.musid.chatterbox

import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter : ListAdapter<Message, MessagesAdapter.MessageViewHolder>(MessageDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_message, parent, false)
        return MessageViewHolder(view)

    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = getItem(position)
        holder.bind(message)


    }




//    override fun getItemCount(): Int = messages.size



    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageTextView: TextView = itemView.findViewById(R.id.textViewMessage)

        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }


    class MessageDiffCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            // Implement your logic to determine if items are the same
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            // Implement your logic to determine if contents of the items are the same
            return oldItem == newItem
        }
    }

}
