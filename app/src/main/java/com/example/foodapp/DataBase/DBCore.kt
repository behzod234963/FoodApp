package com.example.foodapp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapp.Models.DBModel

@Database(entities = [DBModel::class], version = 3)
abstract class DBCore:RoomDatabase() {

    abstract fun getDao():DBInterface

    companion object{

        private var DB_INSTANCE:DBCore? =null
        fun foodsDataBase(ctx:Context):DBCore{

            if (DB_INSTANCE==null){

                DB_INSTANCE= Room.databaseBuilder(ctx.applicationContext,DBCore::class.java,"food").allowMainThreadQueries().build()


            }

            return DB_INSTANCE!!

        }

    }

}