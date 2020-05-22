@EventListener(SessionConnectEvent.class)
public void handleWebsocketConnectListner(SessionConnectEvent event) {
    logger.info("Received a new web socket connection : " + now());
}

@EventListener(SessionDisconnectEvent.class)
public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
    logger.info("session closed : " + now());
}