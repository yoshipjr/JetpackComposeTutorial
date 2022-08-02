package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import com.example.jetpackcomposetutorial.dataSource.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.dataSource.SampleData
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import com.example.jetpackcomposetutorial.widget.MessageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
//                Conversation(messages = SampleData.conversationSample)
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(name = "Android")
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    widthDp = 320
)
@Composable
fun PreviewConversation() {
    JetpackComposeTutorialTheme {
//        Conversation(messages = SampleData.conversationSample)
        Surface(color = MaterialTheme.colors.background) {
//            Greeting(name = "Android")
            MyApp()
        }

    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false)}
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp), ) {
            Column(
                modifier = Modifier.weight(1f).padding(bottom = extraPadding)
            ) {
                Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
                Text(text = name)
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if(expanded.value) "Show less" else "Show more")
            }
        }
    }
}
