@Configuration
@EnableJms
public class JmsConfiguration implements JmsListenerConfigurer {

    @Value("${message-consumer.destination}")
    private String destination;

    @Inject
    private MessageListener messageListener;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
        endpoint.setId("audit.logging");
        endpoint.setDestination(destination);
        endpoint.setMessageListener(messageListener);
        registrar.registerEndpoint(endpoint);
    }