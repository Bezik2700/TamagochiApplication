package com.example.tamagochiapplication.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")

class DataStoreManager(private val context: Context) {

    suspend fun saveSettings(settingData: SettingData) {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey("userName")] = settingData.userName
            pref[intPreferencesKey("userEatValue")] = settingData.userEatValue
            pref[intPreferencesKey("userHealthValue")] = settingData.userHealthValue
            pref[intPreferencesKey("userHappinessValue")] = settingData.userHappinessValue
            pref[booleanPreferencesKey("appMenuState")] = settingData.appMenuState
        }
    }

    fun getSettings() = context.dataStore.data.map { pref ->
        return@map SettingData(
            pref[stringPreferencesKey("userName")] ?: "",
            pref[intPreferencesKey("userEatValue")] ?: 0,
            pref[intPreferencesKey("userHealthValue")] ?: 0,
            pref[intPreferencesKey("userHappinessValue")] ?: 0,
            pref[booleanPreferencesKey("appMenuState")] == true
        )
    }
}

data class SettingData(
    val userName: String,
    val userEatValue: Int,
    val userHealthValue: Int,
    val userHappinessValue: Int,
    val appMenuState: Boolean
)