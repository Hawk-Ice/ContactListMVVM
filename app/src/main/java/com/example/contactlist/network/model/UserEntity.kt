package com.example.contactlist.network.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "contacts")
data class UserEntity (
    @PrimaryKey
    @SerializedName("id"         ) var id        : Int?    = null,

    @ColumnInfo(name = "email")
    @SerializedName("email"      ) var email     : String? = null,

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name" ) var firstName : String? = null,

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name"  ) var lastName  : String? = null,

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar"     ) var avatar    : String? = null
)