@SpringBootApplication
public class RabbitJmsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitJmsApplication.class, args);
    }

    @Autowired
    private JmsTemplate template;

    @Override
    public void run(String... arg0) throws Exception {
        template.convertAndSend("foo", "bar");
        template.setReceiveTimeout(10_000);
        System.out.println(template.receiveAndConvert("foo"));
    }

    @Bean
    public RMQConnectionFactory connectionFactory() {
        return new RMQConnectionFactory();
    }

}