String urlConnect = "wss://test.test.com:11111/websocket";
WebSocket webSocket = new WebSocket.OnTextMessage() {...};

WebSocketClientFactory webSocketClientFactory = new WebSocketClientFactory();
webSocketClientFactory.setBufferSize(100000); //set this size as you need
webSocketClientFactory.start();

WebSocketClient webSocketClient = webSocketClientFactory.newWebSocketClient();
webSocketClient.setMaxBinaryMessageSize(100000);//set this size as you need
webSocketClient.setMaxTextMessageSize(100000);//set this size as you need
webSocketClient.open(URI.create(urlConnect), webSocket);