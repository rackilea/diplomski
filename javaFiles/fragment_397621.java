@SpringBootApplication
public class So36837736Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So36837736Application.class, args);
        context.getBean(RabbitTemplate.class).convertAndSend(new Foo("bar"));
        Thread.sleep(10000);
        context.close();
    }

    @Bean
    public RabbitTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setRoutingKey(queue().getName());
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue());
        MessageListenerAdapter adapter = new MessageListenerAdapter(new Object() {

            @SuppressWarnings("unused")
            public void handleMessage(Map<String, Object> map) {
                System.out.println("\n\n\n" + map + "\n\n\n");
            }

        });
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        ClassMapper classMapper = new ClassMapper() {

            @Override
            public void fromClass(Class<?> clazz, MessageProperties properties) {
            }

            @Override
            public Class<?> toClass(MessageProperties properties) {
                return HashMap.class;
            }

        };
        messageConverter.setClassMapper(classMapper);
        adapter.setMessageConverter(messageConverter);
        container.setMessageListener(adapter);
        return container;
    }

    @Bean
    public Queue queue() {
        return new AnonymousQueue();
    }

    public static class Foo {

        private final String bar;

        private Foo(String bar) {
            this.bar = bar;
        }

        public String getBar() {
            return this.bar;
        }

    }

}