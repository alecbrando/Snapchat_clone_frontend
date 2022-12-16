package com.example.snapchatclonefrontend.presentation.screens.chatscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.snapchatclonefrontend.navigation.Screens

@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = hiltViewModel()
) {
    val state = remember { mutableStateOf(State("", listOf())) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.value.messages) {
                MessageItem(message = it)
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            TextField(
                value = state.value.inputText,
                onValueChange = { state.value.inputText = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Button(
                onClick = {
//                    state.value.messages += state.value.inputText
//                    state.value.inputText = ""
                    viewModel.messages.add("hello")
                    navController.navigate(Screens.Splash.route)
                }
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun MessageItem(message: String) {
    Text(
        text = message,
        modifier = Modifier.padding(16.dp)
    )
}

data class State(var inputText: String, var messages: List<String>)


@Preview
@Composable
fun PreviewChatScreen() {
    ChatScreen(rememberNavController())
}