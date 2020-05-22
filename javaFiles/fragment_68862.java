@SpringBootApplication
public class So56319999Application {

    public static void main(String[] args) {
        SpringApplication.run(So56319999Application.class, args);
    }

    @RabbitListener(queues = "so56319999", exclusive = true)
    public void listen (String in) {

    }

    @Bean
    public Queue queue() {
        return new Queue("so56319999");
    }

}