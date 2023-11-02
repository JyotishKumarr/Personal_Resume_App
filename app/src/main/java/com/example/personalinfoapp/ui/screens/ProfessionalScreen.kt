package com.example.personalinfoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.navigation.compose.rememberNavController
import com.example.personalinfoapp.ui.TextComponent
import com.example.personalinfoapp.ui.TopBar2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfessionalScreen(username: String?,profileSelected: String?) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                        TopBar2(name = "\tWelcome $username \uDB3D", color = Color.White, Bcolor = Color(0xFF0360AA))
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action here */
                        navController.navigate(Routes.USER_SCREEN)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
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
            .padding(contentPadding)
            .fillMaxSize()) {
            Spacer(modifier = Modifier.padding(10.dp))
            TextComponent(textValue = "Thank you! for sharing your data1", textSize = 24.sp)
        }
    }
}
// Should add skills, achiements and responsibilities, Hobbies and community service
