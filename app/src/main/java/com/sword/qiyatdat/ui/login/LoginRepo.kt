package com.sword.qiyatdat.ui.login

import com.sword.qiyatdat.api.Api
import com.sword.qiyatdat.base.BaseRepository
import com.sword.qiyatdat.model.LoginRequest
import com.sword.qiyatdat.model.LoginSuccess

class LoginRepo(private val api: Api) : BaseRepository() {
    suspend fun getTodo(id: Int) = api.getTodo(id)
}