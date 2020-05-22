@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    protected final Logger log = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS().setInterceptors(httpSessionIdHandshakeInterceptor());
    }

    public class HttpSessionIdHandshakeInterceptor implements HandshakeInterceptor {

        @Override
        public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
            log.debug("beforeHandshake");
            if (request instanceof ServletServerHttpRequest) {

                ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;

                HttpSession session = servletRequest.getServletRequest().getSession(false);
                // **** This is the request URI **********
                URI uri = servletRequest.getURI();

            }
            return true;
        }

        public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                Exception ex) {
            log.debug("afterHandshake");
        }

    }

     @Bean
     public HttpSessionIdHandshakeInterceptor httpSessionIdHandshakeInterceptor() {
      return new HttpSessionIdHandshakeInterceptor();
     }

}