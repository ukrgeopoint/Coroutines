package com.example.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Empty)
    val uiState: LiveData<UIState> = _uiState

    fun getData() {
        _uiState.value = UIState.Processing
        viewModelScope.launch {
            val result = Coroutines.doWork()
            _uiState.postValue(UIState.Result(result))
        }
    }

    sealed class UIState {
        data object Empty : UIState()
        data object Processing : UIState()
        class  Result(val title: String) : UIState()

    }
}