package com.example.personalinfoapp.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalinfoapp.R

@Composable
fun TopBar(name: String,color:Color = Color.Black,Bcolor:Color = Color.White) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = name,
            color = color,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Top App bar Image",
            Modifier
                .size(40.dp)
                .background(color = Bcolor)
        )
    }
}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, color: Color = Color.Black) {
    Text(
        text = textValue,
        fontSize = textSize,
        color = color,
        fontWeight = FontWeight.Medium
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(onTextChanged: (name: String) -> Unit) {
    var currentValue by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        modifier = Modifier
            .width(350.dp)
            .height(60.dp),
        placeholder = { Text(text = "Type your name", fontSize = 18.sp) },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions { localFocusManager.clearFocus() }
    )
}

@Composable
fun ProfileCard(
    image: Int,
    selected: Boolean,
    onSelect: (profilename: String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .padding(18.dp)
            .size(120.dp), shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    )
    {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(0xFFC9E5FC))
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {

            Image(painter = painterResource(id = image),
                contentDescription = "profile card",
                modifier = Modifier
                    .padding(33.dp)
                    .clickable {
                        val profileName = if (image == R.drawable.img_3) {
                            "Personal details"
                        } else if (image == R.drawable.img_4) {
                            "Educational Details"
                        } else if (image == R.drawable.img_5) {
                            "Professional work"
                        } else if (image == R.drawable.img_6) {
                            "Location"
                        } else {
                            "Personal details"
                        }
                        onSelect(profileName)
                        localFocusManager.clearFocus()
                    }
                    .wrapContentWidth()
                    .wrapContentHeight()
            )


        }

    }
}

@Composable
fun ButtonComponent(goToDetailsScreen: () -> Unit) {
    Button(modifier = Modifier.width(350.dp).height(60.dp).background(Color(0xFF0360AA)).border(1.dp, color = Color(0xFF0360AA), shape = RoundedCornerShape(8.dp)), onClick = { goToDetailsScreen() }, colors = ButtonDefaults.buttonColors(
        Color(0xFF0360AA)
    )) {
        TextComponent(textValue = "Go to details", textSize = 18.sp, color = Color.White)
    }
}

@Composable
fun TextComponentPersonal(textValue: String, textSize: TextUnit, color: Color = Color.Black,Bcolor: Color = Color.White,fontWeight:FontWeight= FontWeight.Medium) {
    Box (modifier = Modifier
        .fillMaxWidth()
        .background(Bcolor)
        .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(8.dp))){
        Text(
            text = textValue,
            fontSize = textSize,
            color = color,
            fontWeight = fontWeight,
            modifier = Modifier.padding(10.dp,10.dp,3.dp,10.dp)
        )
    }
}

@Composable
fun TopBar2(name: String,color:Color = Color.Black,Bcolor:Color = Color.White) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Bcolor, shape = RoundedCornerShape(20.dp))
        .padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = name,
            color = color,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Top App bar Image",
            Modifier
                .size(40.dp)
                .background(color = Bcolor)
        )
    }
}

@Composable
fun EducationCard(id:Int,schoolName:String,gpa:String,btext:String){
    var isFlipped by remember { mutableStateOf(false) }

    val rotationY by animateFloatAsState(targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 1200) ,label = "")

    Card(modifier = Modifier
        .padding(18.dp)
        .graphicsLayer(
            rotationY = rotationY,
            transformOrigin = TransformOrigin.Center
        )
        .clickable { isFlipped = !isFlipped }
        .size(300.dp, 200.dp), shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(6.dp), colors = CardDefaults.cardColors(Color(
            0xFFB4DBFA
        )
        )) {
        if (isFlipped) {
            // Back side of the card
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Apply a rotation transformation to make the text readable
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                    Text(text = "Specialization",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.graphicsLayer(rotationY = 180f))
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = btext,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.graphicsLayer(rotationY = 180f))
                }
            }
        } else{
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = id),
                    contentDescription = "Top App bar Image",
                    Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Institute Name",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = schoolName,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Percentage",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = gpa,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light)



            }
        }

    }
}

@Preview
@Composable
fun preview4(){
    EducationCard(id = R.drawable.img_7,schoolName = "STBEM High School", gpa = "10", btext = "background Text")
}