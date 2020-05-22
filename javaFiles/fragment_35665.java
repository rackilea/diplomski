@SpringBootApplication
public class So52891334Application {

    public static void main(String[] args) {
        SpringApplication.run(So52891334Application.class, args);
    }

    @JmsListener(destination = "foo")
    public void listen(String payload, @Header("bar") String bar,
                                       @Header("qux") int qux) {
        System.out.println(payload + ", bar header: " + bar + ", qux header: " + qux);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("foo", "test", m -> {
            m.setStringProperty("bar", "baz");
            m.setIntProperty("qux", 42);
            return m;
        });
    }

}