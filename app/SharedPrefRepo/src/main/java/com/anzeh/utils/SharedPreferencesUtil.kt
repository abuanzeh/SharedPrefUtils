package com.anzeh.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SharedPreferencesUtil private constructor() {

    private lateinit var oSharedPreferences: SharedPreferences
    private lateinit var oEditor: SharedPreferences.Editor

    companion object {

        @Volatile
        private var INSTANCE: SharedPreferencesUtil? = null

        fun getInstance(context: Context): SharedPreferencesUtil =
            INSTANCE
                ?: SharedPreferencesUtil(
                    context
                )
                    .also { INSTANCE = it }
    }

    private constructor(context: Context) : this() {
        oSharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
        oEditor = oSharedPreferences.edit()
        oEditor.apply()
    }


    fun clearPreference(): Boolean {
        return oEditor.clear().commit()
    }


    fun setFloatPreferences(key: String, value: Float) {
        oEditor.putFloat(key, value)
            .apply()
    }

    fun getFloatPreferences(key: String, defaultValue: Float): Float {
        return oSharedPreferences.getFloat(key, defaultValue)
    }


    fun setLongPreferences(key: String, value: Long) {
        oEditor.putLong(key, value)
            .apply()
    }

    fun getLongPreferences(key: String, defaultValue: Long): Long {
        return oSharedPreferences.getLong(key, defaultValue)
    }


    fun setIntPreferences(key: String, value: Int) {
        oEditor.putInt(key, value)
            .apply()
    }

    fun getIntPreferences(key: String, defaultValue: Int): Int {
        return oSharedPreferences.getInt(key, defaultValue)
    }

    fun setStringPreferences(key: String, value: String) {
        oEditor.putString(key, value)
            .apply()
    }

    fun getStringPreferences(key: String, defaultValue: String?): String {
        return oSharedPreferences.getString(key, defaultValue) ?: defaultValue ?: ""
    }

    fun setBooleanPreferences(key: String, value: Boolean) {
        oEditor.putBoolean(key, value).apply()
    }


    fun getBooleanPreferences(key: String, defaultValue: Boolean): Boolean {
        return oSharedPreferences.getBoolean(key, defaultValue)
    }

    fun <T> saveList(key: String?, list: List<T>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        oEditor.putString(key, json)
        oEditor.apply()
    }

     fun <T> getList(key: String): List<T?>? {
        val arrayItems: List<T>
        val serializedObject: String = getStringPreferences(key, null)
        val gson = Gson()
        val type: Type = object : TypeToken<List<T?>?>() {}.type
        arrayItems = gson.fromJson(serializedObject, type)
        return arrayItems

    }


}