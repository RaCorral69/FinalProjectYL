
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalprojectyl.components.HeaderText
import com.example.finalprojectyl.login.defaultPadding
import com.example.finalprojectyl.login.itemSpacing
import com.example.finalprojectyl.ui.theme.FinalProjectYLTheme

val defaultPadding = 16.dp
val itemSpacing = 8.dp
@Composable
fun HomeScreen( onYogaTimerClick: () -> Unit, onForumScreenClick:()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            text = "Welcome to YogaLite!",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        Spacer(Modifier.height(itemSpacing))

Column( modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Button(
        onClick = onYogaTimerClick,
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(text = "Yoga Timer")
    }
    Spacer(Modifier.height(itemSpacing))


    Button(
        onClick = onForumScreenClick,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "Forum")

    }
}
    }
}
@Preview(showBackground = true)
@Composable
fun PrevHomeScreen(){
    FinalProjectYLTheme {
        HomeScreen({},{})
    }
}

