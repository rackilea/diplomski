@SpringBootApplication
public class So54207780Application {

    public static void main(String[] args) {
        SpringApplication.run(So54207780Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> template.convertAndSend("fanout", "", "foo", m -> {
            m.getMessageProperties().setReplyTo("replies");
            return m;
        });
    }

    @RabbitListener(queues = "queue1")
    public String listen1(String in) {
        return in.toUpperCase();
    }

    @RabbitListener(queues = "queue2")
    public String listen2(String in) {
        return in + in;
    }

    @RabbitListener(queues = "replies")
    public void replyHandler(String reply) {
        System.out.println(reply);
    }

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("fanout");
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(fanout());
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanout());
    }

    @Bean
    public Queue replies() {
        return new Queue("replies");
    }

}