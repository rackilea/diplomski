@Bean
public WebSocketHandler myHandler() {
    return new PerConnectionWebSocketHandler(MyHandler.class));
}

@Bean
public WebSocketHandler myHandlerDecorator() {
    return new ExceptionWebSocketHandlerDecorator(myHandler());
}