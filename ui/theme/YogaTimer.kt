package com.example.finalprojectyl.ui.theme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun YogaTimer(onReturnClick: () -> Unit) {
    var timerValue by remember { mutableStateOf(3) }
    var timerRunning by remember { mutableStateOf(false) }
    var timeLeft by remember { mutableStateOf(timerValue) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Yoga Timer",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Timer Duration:")
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { timerValue = 3 }) {
                Text("3 seconds")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { timerValue = 5 }) {
                Text("5 seconds")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { timerValue = 10 }) {
                Text("10 seconds")
            }
        }

        Text(
            text = "Time remaining: $timeLeft seconds",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (!timerRunning) {
            Button(
                onClick = {
                    timerRunning = true
                    timeLeft = timerValue
                    coroutineScope.launch {
                        while (timeLeft > 0) {
                            delay(1000)
                            timeLeft--
                        }
                        timerRunning = false
                    }
                },
                enabled = !timerRunning
            ) {
                Text("Start Timer")
            }
        }

        Button(
            onClick = onReturnClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Return")
        }
    }
}


@Preview
@Composable
fun prevYogaTimer(){
    FinalProjectYLTheme {
        YogaTimer({})
    }
}