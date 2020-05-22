@SpringBootApplication
public class So42328067Application {

    private static final String FANOUT = "fanout";

    private static final String QUEUE = "foo";

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So42328067Application.class, args);
        context.getBean(RabbitTemplate.class).convertAndSend(FANOUT, "", "bar");
        Thread.sleep(5000);
        context.close();
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(FANOUT);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange());
    }

    @RabbitListener(queues = QUEUE)
    public void listen(String in) {
        System.out.println(in);
    }

}