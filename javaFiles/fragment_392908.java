@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private static final Logger log = LoggerFactory.getLogger(WebSocketConfig.class);
    @Value("${spring.rabbitmq.username}")
    private String userName;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${endpoint}")
    private String endpoint;
    @Value("${destination.prefix}")
    private String destinationPrefix;
    @Value("${stomp.broker.relay}")
    private String stompBrokerRelay;
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        config.enableStompBrokerRelay(stompBrokerRelay).setRelayHost(host).setRelayPort(port).setSystemLogin(userName).setSystemPasscode(password);
        config.setApplicationDestinationPrefixes(destinationPrefix);
    }
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint(endpoint).setAllowedOrigins("*").withSockJS();
    }
}