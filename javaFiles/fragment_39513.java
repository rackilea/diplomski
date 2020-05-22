@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws").setHandshakeHandler(handshakeHandler());
    registry.addEndpoint("/ws").setHandshakeHandler(handshakeHandler()).withSockJS();
  }

  @Bean
  public DefaultHandshakeHandler handshakeHandler() {
    WebSocketPolicy policy = WebSocketPolicy.newServerPolicy();
    policy.setMaxTextMessageSize(128 * 1024);

    return new DefaultHandshakeHandler(new JettyRequestUpgradeStrategy(policy));
  }
}