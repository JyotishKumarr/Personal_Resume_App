package com.example.personalinfoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalinfoapp.R
import com.example.personalinfoapp.ui.TextComponentPersonal
import com.example.personalinfoapp.ui.TopBar2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalScreen(username: String?, profileSelected: String?) {
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
        // Screen content
        Column(modifier = Modifier.padding(contentPadding)
            .fillMaxSize().verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Round Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .padding(20.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.DarkGray, CircleShape)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TextComponentPersonal(textValue = "Name\t\t\t\t\t\t\t\t\t\t\t : \t name", textSize = 20.sp, fontWeight = FontWeight.Medium, Bcolor = Color(0xFFDAEFFF))
            TextComponentPersonal(textValue = "DOB \t\t\t\t\t\t\t\t\t\t\t\t : \tDOB", textSize = 20.sp, fontWeight = FontWeight.Medium)
            TextComponentPersonal(textValue = "Gender\t\t\t\t\t\t\t\t\t : \tGENDER", textSize = 20.sp, fontWeight = FontWeight.Medium, Bcolor = Color(0xFFDAEFFF))
            TextComponentPersonal(textValue = "Phone No.\t\t\t\t : \tPH NO", textSize = 20.sp, fontWeight = FontWeight.Medium)
            TextComponentPersonal(textValue = "Nationality\t\t\t\t : \tNATIONALITY", textSize = 20.sp, fontWeight = FontWeight.Medium, Bcolor = Color(0xFFDAEFFF))
            TextComponentPersonal(textValue = "Religion\t\t\t\t\t\t\t\t : \tRELIGION", textSize = 20.sp, fontWeight = FontWeight.Medium)
            TextComponentPersonal(textValue = "Address\t\t\t\t\t\t\t\t : \tADDRESS", textSize = 20.sp, fontWeight = FontWeight.Medium, Bcolor = Color(0xFFDAEFFF))
            TextComponentPersonal(textValue = "Email Add.\t\t\t\t : \tMAIL", textSize = 20.sp, fontWeight = FontWeight.Medium)
            TextComponentPersonal(textValue = "Marital Status : \tSINGLE", textSize = 20.sp, fontWeight = FontWeight.Medium, Bcolor = Color(0xFFDAEFFF))
            //Have to add social media accounts and access
        }
    }
}




@Composable
@Preview
fun preview(){
    PersonalScreen(username = "",profileSelected = "")
}