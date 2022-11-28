package com.example.contactlist.network.`interface`

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.contactlist.network.model.UserEntity


@Dao
interface RoomDAO {
    @Query("SELECT * FROM contacts")
    fun getAll(): LiveData<List<UserEntity>>

    @Insert
    suspend fun insertAll(vararg users: UserEntity)
}