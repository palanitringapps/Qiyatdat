package com.sword.qiyatdat.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sword.qiyatdat.api.ApiFactory
import com.sword.qiyatdat.base.BaseViewModel
import com.sword.qiyatdat.model.LoginRequest
import com.sword.qiyatdat.model.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(application: Application) : BaseViewModel(application) {
    private val loginRepo = LoginRepo(ApiFactory.makeRetrofitService())
    private var loginSuccess: LoginSuccess? = null

    fun callLog() {
        callLogin("eve.holt@reqres.in", "cityslicka")
    }

    fun callLogin(username: String, password: String) {
        if (validateFeilds(username, password)) {
            uiScope.launch {
                loginSuccess = getLoginCallInfo()
                Log.i("jshdsgfjsdf", "jhsgdfsjd ${loginSuccess!!.title}")
            }
        }
    }

    private fun validateFeilds(username: String, password: String): Boolean {
        return username.isNotBlank() && password.isNotBlank()
    }

    private suspend fun getLoginCallInfo(): LoginSuccess? =
        withContext(Dispatchers.IO) {
            return@withContext loginRepo.getTodo(1)
        }


    class LoginViewModelFactory(private var app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Application::class.java).newInstance(app)
        }

    }
}
