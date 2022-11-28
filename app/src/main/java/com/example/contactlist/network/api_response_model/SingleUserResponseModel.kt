package com.example.contactlist.network.api_response_model

import com.example.contactlist.network.model.UserEntity
import com.google.gson.annotations.SerializedName

class SingleUserResponseModel {
    @SerializedName("data"    ) var data    : UserEntity?    = UserEntity()
}