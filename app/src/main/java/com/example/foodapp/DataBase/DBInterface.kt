package com.example.foodapp.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.Models.DBModel

@Dao
interface DBInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFood(food: DBModel)

    @Query("SELECT *FROM food")
    fun getAllFood():List<DBModel>

    @Query("SELECT *FROM food WHERE :id=id")
    fun getFoodById(id:Int):List<DBModel>

    @Query("SELECT *FROM food WHERE :name=name")
    fun getFoodByName(name:String):List<DBModel>

    @Delete
    fun clearFoods(food:List<DBModel>)

}