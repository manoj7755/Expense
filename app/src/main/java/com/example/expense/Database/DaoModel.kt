package com.example.expense.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoModel {
    @Insert
    fun insertData(DBmodel: DatabaseModel)

    @Query("select * from Expense")
    fun getData() :LiveData<List<DatabaseModel>>
    @Update
    fun update(ExpeModel:DatabaseModel)
    @Delete
    fun delete(ExpeModel: DatabaseModel)
}