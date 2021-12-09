package com.example.authenticationapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationapp.database.Identity
import com.example.authenticationapp.database.IdentityDao
import kotlinx.coroutines.launch

class IdentityViewModel(private val identityDao: IdentityDao): ViewModel() {



    fun addNewIdentity(identityName: String) {

    val newName = getNewIdentity(identityName)
        insertIdentity(newName)

    }

    private fun insertIdentity(identity: Identity){
        viewModelScope.launch {
            identityDao.insert(identity)
        }
    }

    private fun getNewIdentity( identityName: String ):Identity {
        return Identity(
        name = identityName
        )
    }

    fun deleteIdentity() {

    }



}