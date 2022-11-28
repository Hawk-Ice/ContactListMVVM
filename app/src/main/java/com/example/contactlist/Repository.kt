package com.example.contactlist

import androidx.lifecycle.LiveData
import com.example.contactlist.network.model.UserEntity
import com.example.contactlist.network.service.RetrofitService
import com.example.contactlist.network.service.RoomDatabaseService

class Repository(

    private val retrofitService: RetrofitService,
    private val roomDatabaseService: RoomDatabaseService
) : RepositoryInterface {

    override suspend fun geDataListFromRoom(): LiveData<List<UserEntity>> {
        return roomDatabaseService.roomDao().getAll()
        TODO("Not yet implemented")
    }

    override suspend fun storeDataListToRoom() {


        TODO("Not yet implemented")
    }

    override suspend fun getDataListFromAPI(): List<UserEntity> {

        return retrofitService.getService().getContactList(2).data
        TODO("Not yet implemented")
    }


}

interface RepositoryInterface{
    suspend fun geDataListFromRoom():LiveData<List<UserEntity>>
    suspend fun storeDataListToRoom()
    suspend fun getDataListFromAPI():List<UserEntity>
}