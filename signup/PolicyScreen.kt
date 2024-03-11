package com.example.finalprojectyl.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PolicyScreen(onBtnClick:() -> Unit){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column{
                Text("Welcome to the Yoga App!")
                Text("Please read and abide by the following guidelines:")
                Text("- Respect other users and their journey in yoga practice.")
                Text("- Avoid using foul language or engaging in bullying behavior.")
                Text("- Use the app to improve your yoga skills and overall well-being.")
            Button(onClick= onBtnClick){
                Text(text = "Finish")
            }
        }
    }
}