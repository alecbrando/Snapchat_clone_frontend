package com.example.snapchatclonefrontend.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object ChatScreen : Screens("chat_screen")
}
