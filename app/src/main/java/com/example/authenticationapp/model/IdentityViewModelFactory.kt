package com.example.authenticationapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationapp.database.IdentityDao


class IdentityViewModelFactory(private val identityDao: IdentityDao)  : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IdentityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IdentityViewModel(identityDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}