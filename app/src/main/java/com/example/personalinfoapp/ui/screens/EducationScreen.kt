package com.example.personalinfoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalinfoapp.R
import com.example.personalinfoapp.ui.EducationCard
import com.example.personalinfoapp.ui.TextComponentPersonal
import com.example.personalinfoapp.ui.TopBar2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationScreen(username: String?,profileSelected: String?) {
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
                    IconButton(onClick = { /* Handle back action here */ }) {
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
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {

            TextComponentPersonal(textValue = "                    Education details", textSize = 20.sp)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "*Note : Click the card to know the Specialization", fontSize = 12.sp, fontWeight = FontWeight.Light)
            EducationCard(id = R.drawable.img_7, schoolName = "SCHOOL NAME", gpa = "GPA", btext = "Secondary school certification")
            Spacer(modifier = Modifier.padding(5.dp))
            EducationCard(id = R.drawable.img_8,schoolName = "CLG NAME", gpa = "GPA", btext = "MPC")
            Spacer(modifier = Modifier.padding(5.dp))
            EducationCard(id = R.drawable.img_9,schoolName = "CLG NAME", gpa = "GPA", btext = "CSE")
        }
    }
}
