package com.example.snapchatclonefrontend.presentation.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.snapchatclonefrontend.presentation.screens.chatscreen.ChatViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: ChatViewModel = hiltViewModel()
) {
    Text(text = viewModel.messages[0])
}