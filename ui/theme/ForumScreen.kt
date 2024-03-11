import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun ForumScreen(onReturnHomeClick: () -> Unit) {
    val statusUpdates = remember { mutableStateListOf<String>() }
    var newStatusUpdate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text field for entering a new status update
        TextField(
            value = newStatusUpdate,
            onValueChange = { newStatusUpdate = it },
            label = { Text("What's on your mind?") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Add the new status update to the list
                    statusUpdates.add(newStatusUpdate)
                    // Clear the text field
                    newStatusUpdate = ""
                }
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Button to post the status update
        Button(
            onClick = {
                // Add the new status update to the list
                statusUpdates.add(newStatusUpdate)
                // Clear the text field
                newStatusUpdate = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Post Status")
        }

        // Button to return to the home screen
        Button(
            onClick = onReturnHomeClick,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Back to Home")
        }

        // Display the list of status updates
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Status Updates:")
            statusUpdates.forEach { status ->
                Text(status)
            }
        }
    }
}
