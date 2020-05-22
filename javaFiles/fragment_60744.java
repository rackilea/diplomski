@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {  
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebsocketEndPoint(), "/websocket")
            .addInterceptors(new HandshakeInterceptor());
    }
}