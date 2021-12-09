package com.example.authenticationapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "identity")
data class Identity(

@PrimaryKey(autoGenerate = true)
val id: Int = 0,

@ColumnInfo(name = "name")
val name:String

)
