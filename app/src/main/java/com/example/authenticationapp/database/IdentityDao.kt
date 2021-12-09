package com.example.authenticationapp.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface IdentityDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert(identity: Identity)

@Update
suspend fun update(identity: Identity)


@Query("Select * from identity where id = :id ")
fun getIdentity(id:Int): Flow<Identity>

@Delete
suspend fun delete(identity: Identity)

@Query("Select * from identity")
fun getIdentities():Flow<List<Identity>>

}