package com.example.contactlist.network.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactlist.network.`interface`.RoomDAO
import com.example.contactlist.network.model.UserEntity


@Database(entities = [UserEntity::class], version = 1)
abstract class RoomDatabaseService : RoomDatabase() {

    abstract fun roomDao():RoomDAO

    companion object{

        @Volatile
        private var INSTANCE : RoomDatabaseService?=null

        fun getDatabase(context : Context):RoomDatabaseService{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }
            // if multiple classes call this, it will wait till one task is done first
            synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseService::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}