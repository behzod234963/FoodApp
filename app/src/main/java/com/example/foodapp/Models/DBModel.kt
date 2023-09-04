package com.example.foodapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class DBModel(
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,
    val name:String,
    val materials:String,
    val process:String)
