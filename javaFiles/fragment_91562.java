@SpringBootApplication
public class So46794317Application {

    public static void main(String[] args) {
        SpringApplication.run(So46794317Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("foo", "bar");
    }

    @JmsListener(destination = "foo")
    public void receive(String in, @Header(JmsHeaders.MESSAGE_ID) String messageId) {
        System.out.println(in + ", id:" + messageId);
    }

}