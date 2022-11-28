package com.example.contactlist.ui_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.R
import com.example.contactlist.network.model.UserEntity
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ContactListAdapter(private val contactList: ArrayList<UserEntity>)
    : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val userName: TextView = itemView.findViewById(R.id.userName)
        val userImage: CircleImageView = itemView.findViewById(R.id.userImage)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item, parent, false)

        view.setOnClickListener { View.OnClickListener{

        } }

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.count();
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val user = contactList[position]

        Picasso.get()
            .load(user.avatar)
            .resize(100,100)
            .into(viewHolder.userImage)

        viewHolder.userName.text = user.firstName+" "+user.lastName

        viewHolder


    }




}