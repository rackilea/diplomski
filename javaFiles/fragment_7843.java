@SpringBootApplication
public class So59196698Application {

    public static void main(String[] args) {
        SpringApplication.run(So59196698Application.class, args);
    }

    @JmsListener(destination = "so59196698")
    public void listen(Message in) {
        System.out.println("Received:" + in);
    }

    @JmsListener(destination = "#{advisoryTopicNames.deliveredTopic}", containerFactory = "topicFactory")
    public void delivered(Message in) {
        System.out.println("Delivered:" + in);
    }

    @JmsListener(destination = "#{advisoryTopicNames.consumedTopic}", containerFactory = "topicFactory")
    public void consumed(Message in) {
        System.out.println("Consumed:" + in);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> {
            Thread.sleep(5000);
            template.convertAndSend("so59196698", "test");
        };
    }

    @Bean
    public JmsListenerContainerFactory<?> topicFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

}

@Component
class AdvisoryTopicNames {

    private static final Destination QUEUE = new ActiveMQQueue("so59196698");

    public String getDeliveredTopic() throws JMSException {
        return AdvisorySupport.getMessageDeliveredAdvisoryTopic(QUEUE).getTopicName();
    }

    public String getConsumedTopic() throws JMSException {
        return AdvisorySupport.getMessageConsumedAdvisoryTopic(QUEUE).getTopicName();
    }

}