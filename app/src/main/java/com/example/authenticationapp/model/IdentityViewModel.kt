package com.example.authenticationapp.model

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.authenticationapp.database.Identity
import com.example.authenticationapp.database.IdentityDao
import kotlinx.coroutines.launch

class IdentityViewModel(private val identityDao: IdentityDao): ViewModel() {

//    val myId: LiveData<Identity> = identityDao

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

    fun isEntryValid(identityName: String):Boolean {
        if (identityName.isBlank()) {
            return false
        }
        return true
    }

    fun retrieveItem(): LiveData<Identity> {

        return identityDao.getIdentity().asLiveData()
    }

}