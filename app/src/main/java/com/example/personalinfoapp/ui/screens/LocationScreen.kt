package com.example.personalinfoapp.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.personalinfoapp.ui.TopBar
import com.example.personalinfoapp.ui.TopBar2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(username: String?,profileSelected: String?){
    val context = LocalContext.current
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
        Column(modifier = Modifier.fillMaxWidth().padding(contentPadding), horizontalAlignment = Alignment.CenterHorizontally) {
            TopBar(name = "Welcome to my Location Screen ,"+username+"\uDB3D")
            Button(onClick = { context.startActivity(Intent(context,MapsActivity::class.java)) }, modifier = Modifier.padding(10.dp),) {
                Text(text = "Click here to know my location")
            }
        }
    }
}

@Preview
@Composable
fun preview2(){
    LocationScreen(username = "hiiiii", profileSelected = "")
}