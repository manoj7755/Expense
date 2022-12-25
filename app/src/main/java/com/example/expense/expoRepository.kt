package com.example.expense

import androidx.lifecycle.LiveData
import com.example.expense.Database.DaoModel
import com.example.expense.Database.DatabaseModel

class expoRepository(val expoDao:DaoModel) {

    fun getData():LiveData<List<DatabaseModel>>{
      return expoDao.getData()
    }
    fun addData( expoModel:DatabaseModel){
      expoDao.insertData(expoModel)
    }
}