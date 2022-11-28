package com.example.contactlist.network.api_response_model

import com.example.contactlist.network.model.UserEntity
import com.google.gson.annotations.SerializedName

class ContactUserListResponseModel {

    @SerializedName("page"        ) var page       : Int?            = null
    @SerializedName("per_page"    ) var perPage    : Int?            = null
    @SerializedName("total"       ) var total      : Int?            = null
    @SerializedName("total_pages" ) var totalPages : Int?            = null
    @SerializedName("data"        ) var data       : ArrayList<UserEntity> = arrayListOf()
}