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
fun PrivacyScreen(onBtnClick:() -> Unit){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column{
            Text("Privacy Policy")
            Text("Information Collection and Use:")
            Text("- YogaLite does not collect any personally identifiable information from its users.")
            Text("Data Storage:")
            Text("- All user data collected by YogaLite is stored securely on our servers.")
            Text("Permissions:")
            Text("- YogaLite may require certain permissions on your device to function properly.")
            Text("Security:")
            Text("- We take the security of user data seriously and implement industry-standard measures to protect against unauthorized access.")
            Text("Children's Privacy:")
            Text("- Yoga is intended for users of all ages and does not knowingly collect personal information from children under 13.")
            Button(onClick= onBtnClick){
                Text(text = "Finish")
            }
        }
    }
}