package com.sword.qiyatdat.api

import com.sword.qiyatdat.model.LoginRequest
import com.sword.qiyatdat.model.LoginSuccess
import retrofit2.Response
import retrofit2.http.*

interface Api {

   /* @POST
    suspend fun getLoginCall(@Url login: String,@Body loginRequest: LoginRequest): Response<LoginSuccess>*/

    @GET("/todos/{id}")
    suspend fun getTodo(@Path(value = "id") todoId: Int): LoginSuccess
}