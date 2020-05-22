@SpringBootApplication
public class So57234770Application {

    public static void main(String[] args) {
        SpringApplication.run(So57234770Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        template.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            template.send("foo", message);
        });
        return args -> {
            template.convertAndSend("BADKEY", "foo");
        };
    }

    @RabbitListener(queues = "foo")
    public void listen(String in) {
        System.out.println(in);
    }

}