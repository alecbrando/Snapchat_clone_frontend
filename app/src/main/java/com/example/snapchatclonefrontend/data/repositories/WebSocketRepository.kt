package com.example.snapchatclonefrontend.data.repositories

import android.util.Log
import okhttp3.*
import javax.inject.Inject


class WebsocketRepository @Inject constructor(
    private val client: OkHttpClient
) {

    val webSocket: WebSocket by lazy {
        val request = Request.Builder()
            .url("http://10.0.2.2:8081/snap-app")
            .build()

        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                // The websocket connection has been established.
                // You can now send data over the websocket using the `send` method.
                Log.d("onOpen", response.message)
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                // A message has been received over the websocket.
                // You can process the message here.
                Log.d("onMessage", text)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                // The websocket is closing.
                // You can clean up any resources here.
                Log.d("Closing", reason)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                // The websocket connection has failed.
                // You can handle the error here.
                Log.d("Error", response?.message ?: "")
            }
        }

        val webSocket = client.newWebSocket(request, listener)

        webSocket
    }
}