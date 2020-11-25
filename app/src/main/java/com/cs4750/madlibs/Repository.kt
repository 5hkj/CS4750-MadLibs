package com.cs4750.madlibs

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.concurrent.Executors


private const val DATABASE_NAME = "MadLibCentral.db"

class Repository private constructor(context: Context){
    private val database: MadLibDatabase = Room.databaseBuilder(
        context.applicationContext,
        MadLibDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val madLibDao = database.madLibDao()

    fun getMadLibs(): LiveData<List<MadLib>> = madLibDao.getLibs()

    companion object{
        private var INSTANCE: Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) { // Only calls constructor if 0 instances of Database exists.
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository{ // Because we are following a singleton design pattern, only one instance must exist
            // Throws exception if the instance has not been created yet.
            return INSTANCE ?: throw IllegalStateException("Repository must be initialized")
        }

    }
}




