package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import com.example.jetpackcomposetutorial.dataSource.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.dataSource.SampleData
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import com.example.jetpackcomposetutorial.widget.MessageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                Conversation(messages = SampleData.conversationSample)
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
    name = "Dark Mode"
)

@Composable
fun PreviewConversation() {
    JetpackComposeTutorialTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}
