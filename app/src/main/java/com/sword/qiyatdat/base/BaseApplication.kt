package com.sword.qiyatdat.base

import android.app.Application
import android.content.res.Configuration
import com.sword.qiyatdat.utils.SharedPreference
import java.util.*


class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //initialize the shared preferences
        SharedPreference.init(this)

        val locale = Locale("ar")
        Locale.setDefault(locale)

        val config: Configuration = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}