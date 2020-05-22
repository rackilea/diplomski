@Configuration
@EnableAutoConfiguration
@EnableWebSocket
public class AppWebSocket {

    public static void main(String[] args) {
        SpringApplication.run(AppWebSocket.class, args);
    }

    @Component
    public static class MyWebSocketConfigurer implements WebSocketConfigurer {

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(new MyTextHandler(), "/text").withSockJS();
            registry.addHandler(new MyBinaryHandler(), "/binary").withSockJS();
        }
    }

    @Component
    public static class MyTextHandler extends TextWebSocketHandler {
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            session.sendMessage(new TextMessage("hello world"));
        }
    }

    @Component
    public static class MyBinaryHandler extends BinaryWebSocketHandler {
        public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
            try {
                session.sendMessage(new BinaryMessage("hello world".getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}