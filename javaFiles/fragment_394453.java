public static void main(String[] args) throws IOException, DeploymentException {
    final WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
    webSocketContainer.connectToServer(MyEndpoint.class, URI.create("ws://some.uri"));
}

@ClientEndpoint
public static class MyEndpoint {

    // text
    @OnMessage
    void onMessage(Session session, String message) {
        // ...
    }

    // binary
    @OnMessage
    void onMessage(Session session, ByteBuffer message) {
        // ...
    }

    // @OnClose, @OnOpen, @OnError
}