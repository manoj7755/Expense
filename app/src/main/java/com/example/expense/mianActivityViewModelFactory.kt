package com.example.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class mianActivityViewModelFactory(val expoRepository: expoRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewsModel(expoRepository) as T
    }
}