private Map<Class<?>, MessageHandler> handlerMap = new HashMap<>();
{
    // register every handler for every message
    handlerMap.put(LoginMessage.class, new LoginHandler());
    // ... more handlers
}

public void dispatchMessage(Message message) {
    MessageHandler handler = handlerMap.get(message.getClass());
    if (handler == null)
        throw new RuntimeException("Unsupported message type");
    handler.process(message);
}