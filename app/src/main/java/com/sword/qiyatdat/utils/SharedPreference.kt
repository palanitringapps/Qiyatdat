package com.sword.qiyatdat.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {
    private const val NAME = Constants.SHARED_PREFERENCES_NAME
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun clearAllPref() {
        preferences.edit().clear()
    }

    fun clearPref(keyStr: String) {
        preferences.edit().remove(keyStr)
    }


    fun updatePref(keyStr: String, value: Any) {
        preferences.edit {

            when (value) {
                is Int -> it.putInt(keyStr, value)
                is String -> it.putString(keyStr, value)
                is Boolean -> it.putBoolean(keyStr, value)
                is Long -> it.putLong(keyStr, value)
            }
        }
    }


    fun getBooleanPref(keyStr: String): Boolean? {
        return preferences.getBoolean(keyStr, false)
    }


    fun getLongPref(keyStr: String): Long? {
        return preferences.getLong(keyStr, 0)
    }

    fun getStringPref(keyStr: String): String? {
        return preferences.getString(keyStr, "")
    }


    fun getIntPref(keyStr: String): Int? {
        return preferences.getInt(keyStr, 0)
    }

}