package com.example.contactlist.network.`interface`

import com.example.contactlist.network.api_response_model.ContactUserListResponseModel
import com.example.contactlist.network.api_response_model.SingleUserResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitDAO {

    @GET("users")
    suspend fun getContactList(
        @Query("page") page:Int,
    ):ContactUserListResponseModel

    @GET("users")
    suspend fun getUser(

    ): SingleUserResponseModel
}