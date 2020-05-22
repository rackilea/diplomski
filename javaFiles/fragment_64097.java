// 1. Create a WebSocketFactory instance.
WebSocketFactory factory = new WebSocketFactory();

// 2. Set up information about a proxy server.
//    Credentials can be set here.
ProxySettings settings = factory.getProxySettings();
settings.setServer("http://proxy.example.com");
settings.setCredentials("id", "password");

// 3. Connect to a WebSocket endpoint via the proxy.
WebSocket ws = factory.createSocket("ws://websocket.example.com");

// 4. Add a listener to receive WebSocket events.
ws.addListener(new WebSocketAdapter() {
    @Override
    public void onTextMessage(WebSocket ws, String message) {
        // Received a text message.
        ......
    }
});

// 5. Perform a WebSocket opening handshake.
ws.connect();

// 6. Send frames.

// 6-1. Text
ws.sendText("Hello.");

// 6-2. Binary
byte[] binary = ......;
ws.sendBinary(binary);

// 6-3. Ping
ws.sendPing("Are you there?");

// 6-4. Pong (unsolicited pong; RFC 6455, 5.5.3. Pong)
ws.sendPong("I'm OK.");

// 6-5. Fragmented Frames
ws.sendText("How ", false)
  .sendContinuation("are ")
  .sendContinuation("you?", true);

// 6-6. Periodical Ping
ws.setPingInterval(60 * 1000);

// 6-7. Periodical Pong (unsolicited pong; RFC 6455, 5.5.3. Pong)
ws.setPongInterval(60 * 1000);

// 6-8. Close (if you want to send one manually).
ws.sendClose(WebSocketCloseCode.NORMAL, "Bye.");

// 7. Disconnect
ws.disconnect();