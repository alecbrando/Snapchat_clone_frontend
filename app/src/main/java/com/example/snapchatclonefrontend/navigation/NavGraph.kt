package com.example.snapchatclonefrontend.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.snapchatclonefrontend.presentation.screens.SplashScreen
import com.example.snapchatclonefrontend.presentation.screens.chatscreen.ChatScreen
import com.example.snapchatclonefrontend.presentation.screens.chatscreen.ChatViewModel

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    viewmodel: ChatViewModel = hiltViewModel()
){
    NavHost(navController = navController, startDestination = Screens.ChatScreen.route) {
        composable(route = Screens.Splash.route){
            SplashScreen(navController, viewmodel)
        }
        composable(route = Screens.ChatScreen.route){
            ChatScreen(navController, viewmodel)
        }
    }
}