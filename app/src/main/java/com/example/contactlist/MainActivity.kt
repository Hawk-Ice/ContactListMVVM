package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlist.databinding.ActivityMainBinding
import com.example.contactlist.network.model.UserEntity
import com.example.contactlist.network.service.RetrofitService
import com.example.contactlist.ui_adapters.ContactListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var mContactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






        CoroutineScope(IO).launch {
//            Log.d("TAG", "RESPONSE: "+ response.data.size)
            mContactViewModel = ViewModelProvider(this@MainActivity).get(ContactViewModel::class.java)
            mContactViewModel.getContactList().observe(this@MainActivity, Observer {
                binding.recyclerView.adapter = ContactListAdapter(it as ArrayList<UserEntity>)
            })

            CoroutineScope(Main).launch {
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                binding.recyclerView.adapter = ContactListAdapter(mContactViewModel.getContactList().value as ArrayList<UserEntity>)
                binding.recyclerView.setHasFixedSize(true)
            }


        }


    }
}