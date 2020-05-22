@SpringBootApplication
public class So51658210Application {

    public static void main(String[] args) {
        SpringApplication.run(So51658210Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template, ApplicationContext context,
            KafkaListenerEndpointRegistry registry) {
        return args -> {
            template.send("so51658210", 0, "", "foo");
            template.send("so51658210", 1, "", "bar");
            template.send("so51658210", 2, "", "baz");
            template.send("so51658210", 0, "", "foo");
            template.send("so51658210", 1, "", "bar");
            template.send("so51658210", 2, "", "baz");
        };
    }

    @Bean
    public ActualListener actualListener() {
        return new ActualListener();
    }

    @Bean
    @Scope("threadScope")
    public ThreadScopedListener listener() {
        return new ThreadScopedListener();
    }

    @Bean
    public static CustomScopeConfigurer scoper() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("threadScope", new SimpleThreadScope());
        return configurer;
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("so51658210", 3, (short) 1);
    }

    public static class ActualListener {

        @Autowired
        private ObjectFactory<ThreadScopedListener> listener;

        @KafkaListener(id = "foo", topics = "so51658210")
        public void listen(String in, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
            this.listener.getObject().doListen(in, partition);
        }

    }

    public static class ThreadScopedListener {

        private void doListen(String in, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
            System.out.println(in + ":"
                    + Thread.currentThread().getName() + ":"
                    + this.hashCode() + ":"
                    + partition);
        }

    }

}