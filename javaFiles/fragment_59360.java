@Override
public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
    registration.setSendTimeLimit(60 * 1000)
            .setSendBufferSizeLimit(200 * 1024 * 1024)
            .setMessageSizeLimit(200 * 1024 * 1024);
}