package com.example.snapchatclonefrontend.presentation.screens.chatscreen

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snapchatclonefrontend.data.repositories.WebsocketRepository
import com.example.snapchatclonefrontend.domain.models.Message
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val okHttpClient: OkHttpClient
): ViewModel() {
    val webSocket = OkHttpClient().newWebSocket(
        Request.Builder().url("ws://10.0.2.2:8081/snap-app").build(),
        object : WebSocketListener() {
            // Handle incoming messages
            override fun onMessage(webSocket: WebSocket, text: String) {
                // Print the message to the console
                println("Received message: $text")
            }
        }
    )
    val messages: MutableList<String> = mutableListOf()
    val messagesLiveData = MutableLiveData<List<String>>()

    fun sendMessage() {
        val gson = Gson()
        
        val data = Message(sender = "alecbrando", recipient = "dantheman", text = "hello world!")
        val request = gson.toJson(data)
        viewModelScope.launch {
            webSocket.send(request)
            delay(3000L)
            webSocket.send(request)
        }
    }

    init {
        sendMessage()
    }
}