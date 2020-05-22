@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

private URI allowOrigin;

@Inject // constructor injection not working in this class, use setter injection instead
public void setAllowOrigin(  @Value( "${allowOrigin}" ) final URI allowOrigin ) {
    this.allowOrigin = Objects.requireNonNull( allowOrigin );
}

@Override
public void configureMessageBroker( final MessageBrokerRegistry config ) {
    config.enableSimpleBroker( "/topic" );
    config.setApplicationDestinationPrefixes( "/app" );
}

@Override
public void registerStompEndpoints( final StompEndpointRegistry registry ) {
    registry.addEndpoint( "/socket" )
            .setAllowedOrigins( allowOrigin.toString() )
            .withSockJS();
}

}