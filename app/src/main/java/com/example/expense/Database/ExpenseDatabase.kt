package com.example.expense.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DatabaseModel::class), version = 1, exportSchema = false)
abstract class ExpenseDatabase:RoomDatabase() {
abstract fun DaoModel(): DaoModel
    companion object{
    val INSTANCE_DB: ExpenseDatabase? =null
    fun getDatabase(context: Context): ExpenseDatabase {
        if (INSTANCE_DB !=null){
            return INSTANCE_DB
        }else{
            synchronized(this){
                val instance  = Room.databaseBuilder(context.applicationContext,
                    ExpenseDatabase::class.java,"ExpenseDataBase").allowMainThreadQueries().build()
                return instance
            }
        }
    }
}

}