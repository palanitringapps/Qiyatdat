package com.sword.qiyatdat.ui.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.sword.qiyatdat.R
import com.sword.qiyatdat.base.BaseActivity
import com.sword.qiyatdat.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ViewDataBinding>() {


    private val viewModel by lazy {
        ViewModelProviders.of(this, application?.let { LoginViewModel.LoginViewModelFactory(it) })
            .get(LoginViewModel::class.java)
    }

    override fun getContentView(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        bind.loginModel = viewModel
    }

}