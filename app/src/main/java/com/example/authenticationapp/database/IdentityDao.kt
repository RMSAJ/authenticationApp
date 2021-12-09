package com.example.authenticationapp.database

import android.content.ClipData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface IdentityDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(identity: Identity)
// get always the last [@Id]
@Query("Select * from identity order by Id Desc Limit 1")
fun getIdentity(): Flow<Identity>


//    @Query("Select * from identity order by name ASC")
//    fun getIdentities(): Flow<List<Identity>>

}