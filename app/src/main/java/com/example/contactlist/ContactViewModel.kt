package com.example.contactlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactlist.network.model.UserEntity

class ContactViewModel (private val repository: Repository) : ViewModel(){



    private lateinit var mContactList: MutableLiveData<List<UserEntity>>


    suspend fun getContactList() : LiveData<List<UserEntity>>{
        mContactList = MutableLiveData(repository.getDataListFromAPI())
        return mContactList
    }
}