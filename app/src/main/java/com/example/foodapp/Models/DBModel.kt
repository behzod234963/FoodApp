package com.example.foodapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class DBModel(
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,
    val name:String?=null,
    val materials:String?=null,
    val process:String?=null)
