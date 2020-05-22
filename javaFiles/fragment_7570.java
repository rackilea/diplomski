@Configuration
@EnableJms
public class AppConfig {

        @Bean
        public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
                DefaultJmsListenerContainerFactory factory =
                                new DefaultJmsListenerContainerFactory();
                factory.setConnectionFactory(connectionFactory());
                factory.setDestinationResolver(destinationResolver());
                factory.setConcurrency("3-10");
                return factory;
        }
}