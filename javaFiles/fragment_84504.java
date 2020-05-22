@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(@NotNull WebSocketHandlerRegistry registry) {
        registry.addHandler(monitoring(), "/socket");
    }

    @Bean
    public Monitoring monitoring() {
        return new Monitoring();
    }
}