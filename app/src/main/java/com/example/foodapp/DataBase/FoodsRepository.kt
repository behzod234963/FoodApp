package com.example.foodapp.DataBase

import android.app.Application
import com.example.foodapp.Models.DBModel

class FoodsRepository(val app:Application) {

    var foodDao=DBCore.foodsDataBase(app).getDao()

    fun saveFood(food: DBModel){

        foodDao.saveFood(food)

    }

    fun getAllFood():List<DBModel>{

        return foodDao.getAllFood()

    }

    fun getFoodByID(id:Int): List<DBModel> {

        return foodDao.getFoodById(id)

    }

    fun getFoodByName(name:String):List<DBModel>{

        return foodDao.getFoodByName(name)

    }


    fun clearALL(food:List<DBModel>){

        foodDao.clearFoods(food)

    }

}