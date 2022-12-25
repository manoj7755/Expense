package com.example.expense

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.expense.Database.DatabaseModel


class mainViewsModel(val repository: expoRepository):ViewModel() {

    fun getData():LiveData<List<DatabaseModel>>{
        return repository.getData()
    }
    fun addData(expodata:DatabaseModel){

        repository.addData(expodata)
    }
}