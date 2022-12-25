package com.example.expense.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expense")
data class DatabaseModel(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val UserName: String,
    val Title:String,
    val Desc:String,
    val Type :String,
    val Amt:Double,
    val TrnasType:String,
    val Date:String
)
