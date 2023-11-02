package com.example.personalinfoapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.personalinfoapp.data.UserInputScreenState
import com.example.personalinfoapp.data.UserInputUiEvents

class UserInputViewModel:ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())
    fun onEvent(event:UserInputUiEvents){
        when(event){
            is UserInputUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(name = event.name)
            }
            is UserInputUiEvents.ProfileSelected -> {
                uiState.value = uiState.value.copy(profileSelected = event.profileSelected)
            }
        }
    }
    fun isValidState() :Boolean{
        return !uiState.value.name.isNullOrEmpty() && !uiState.value.profileSelected.isNullOrEmpty()
    }
}