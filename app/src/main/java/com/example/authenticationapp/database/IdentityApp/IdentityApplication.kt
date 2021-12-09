package com.example.authenticationapp.database.IdentityApp

import android.app.Application
import com.example.authenticationapp.database.IdentityRoomDataBase

class IdentityApplication: Application() {

    val dataBase: IdentityRoomDataBase by lazy { IdentityRoomDataBase.getDataBase(this) }

}