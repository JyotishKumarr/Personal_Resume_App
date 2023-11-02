package com.example.personalinfoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalinfoapp.R
import com.example.personalinfoapp.UserInputViewModel
import com.example.personalinfoapp.data.UserInputUiEvents
import com.example.personalinfoapp.ui.ButtonComponent
import com.example.personalinfoapp.ui.ProfileCard
import com.example.personalinfoapp.ui.TextComponent
import com.example.personalinfoapp.ui.TextFieldComponent
import com.example.personalinfoapp.ui.TopBar2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(userInputViewModel: UserInputViewModel,showScreen: (valuesPair:Pair<String,String>)->Unit){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                        TopBar2(name = "\tHi there  \uDB3D", color = Color.White, Bcolor = Color(0xFF0360AA))
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action here */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF0360AA) )
            )
        }
    ) { contentPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding), horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.size(15.dp))
            TextComponent(textValue = "Welcome to my app", textSize = 24.sp)
            Spacer(modifier = Modifier.size(15.dp))
            TextComponent(textValue = "Please enter your name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(30.dp))
            TextFieldComponent(onTextChanged = {userInputViewModel.onEvent(UserInputUiEvents.UserNameEntered(it))})
            Spacer(modifier = Modifier.size(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                ProfileCard(image = R.drawable.img_3,
                    selected = userInputViewModel.uiState.value.profileSelected=="Personal details",
                    onSelect = {userInputViewModel.onEvent(UserInputUiEvents.ProfileSelected(it))})
                ProfileCard(image = R.drawable.img_4,
                    selected = userInputViewModel.uiState.value.profileSelected=="Educational Details",
                    onSelect = {userInputViewModel.onEvent(UserInputUiEvents.ProfileSelected(it))})
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                ProfileCard( image = R.drawable.img_5,
                    selected = userInputViewModel.uiState.value.profileSelected=="Professional work",
                    onSelect = {userInputViewModel.onEvent(UserInputUiEvents.ProfileSelected(it))})
                ProfileCard(image = R.drawable.img_6,
                    selected = userInputViewModel.uiState.value.profileSelected=="Location",
                    onSelect = {userInputViewModel.onEvent(UserInputUiEvents.ProfileSelected(it))})
            }
            Spacer(modifier = Modifier.padding(30.dp))
            if (userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen={
                        showScreen(
                            Pair(
                                userInputViewModel.uiState.value.name,
                                userInputViewModel.uiState.value.profileSelected
                            )
                        )
                    }
                )
            }
        }
    }
}