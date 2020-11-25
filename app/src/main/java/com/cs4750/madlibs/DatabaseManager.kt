package com.cs4750.madlibs

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MadLibDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMadLib(vararg users: MadLib)

    @Query(value = "SELECT * FROM Libs")
    fun getLibs() :  LiveData<List<MadLib>>
}


@Database(entities = [MadLib::class], version = 1)
@TypeConverters((MadLibConverters::class))
abstract class MadLibDatabase : RoomDatabase() {
    abstract fun madLibDao(): MadLibDao
}


class MadLibConverters{

    @TypeConverter
    fun fromList(params:List<String>): String {
        return params.joinToString(",")
    }


    @TypeConverter
    fun toList(str: String): List<String>{
        return str.split(",")
    }

}