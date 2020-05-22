@SpringBootApplication
public class So49861714Application {

    public static void main(String[] args) {
        SpringApplication.run(So49861714Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("foo", "testMessage");
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory,
            ErrorHandler myErrorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(myErrorHandler);
        return factory;
    }

    @Bean
    public ErrorHandler myErrorHandler() {
        return t -> {
            System.out.println("In error handler");
            t.printStackTrace();
        };
    }

    @JmsListener(destination = "foo")
    public void listen(String in) {
        System.out.println(in);
        throw new RuntimeException("test");
    }

}