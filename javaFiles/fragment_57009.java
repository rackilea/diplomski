@SpringBootApplication
public class So55038881Application {

    public static void main(String[] args) {
        SpringApplication.run(So55038881Application.class, args);
    }

    @JmsListener(destination = "so55038881")
    public void listen(String in, Session session) {
        System.out.println(in + ":" + session);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("so55038881", "foo");
    }

}