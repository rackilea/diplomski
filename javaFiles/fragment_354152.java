@SpringBootApplication
public class So53503830Application {

    public static void main(String[] args) {
        SpringApplication.run(So53503830Application.class, args);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Autowired
    private ConsumerFactory<String, String> cf;

    @Bean
    public ApplicationRunner runner(Foo foo) {
        return args -> {
            ContainerProperties props = new ContainerProperties("topic");
            KafkaMessageListenerContainer<String, String> container = new KafkaMessageListenerContainer<>(this.cf,  props);
            foo.referenceOldClass(container);
        };
    }

}