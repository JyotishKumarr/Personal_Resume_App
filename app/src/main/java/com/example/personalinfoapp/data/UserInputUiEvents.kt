package com.example.personalinfoapp.data

sealed class UserInputUiEvents {
    data class UserNameEntered(val name:String):UserInputUiEvents()
    data class ProfileSelected(val profileSelected:String):UserInputUiEvents()
}