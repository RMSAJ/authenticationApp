package com.example.authenticationapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Identity::class], version = 2, exportSchema = false)
abstract class IdentityRoomDataBase : RoomDatabase() {

    abstract fun identityDao(): IdentityDao

    companion object {
        @Volatile
        private var INSTANCE: IdentityRoomDataBase? = null

        fun getDataBase(context: Context): IdentityRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IdentityRoomDataBase::class.java,
                    "identity_dataBase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}