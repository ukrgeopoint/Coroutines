package com.example.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Empty)
    val uiState: LiveData<UIState> = _uiState
    private val repo = MyApplication.getApp().repo

    fun getData() {
        _uiState.value = UIState.Processing

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = repo.getCurrencyByName("bitcoin")
                if (response.data != null) {
                    _uiState.postValue(
                        UIState.Result("${response.data.id} ${response.data.rateUsd}")
                    )
                } else {
                    _uiState.postValue(UIState.Error("Error"))
                }
            }
        }
    }

    sealed class UIState {
        data object Empty : UIState()
        data object Processing : UIState()
        class Result(val title: String) : UIState()
        class Error(val description: String) : UIState()

    }
}