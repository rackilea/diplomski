final WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();

    Session session = webSocketContainer.connectToServer(new Endpoint() {
        @Override
        public void onOpen(Session session, EndpointConfig config) {
            // session.addMessageHandler( ... );
        }
    }, URI.create("ws://some.uri"));