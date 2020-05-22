@SpringBootApplication
public class So46973604Application {

    private final Logger LOGGER = LoggerFactory.getLogger(So46973604Application.class);

    public static void main(String[] args) {
        SpringApplication.run(So46973604Application.class, args).close();
    }

    @Bean
    ApplicationRunner runner(Gate gate) {
        return args -> {
            for (int i = 0; i < 20; i++) {
                gate.send("foo");
                LOGGER.info("Sent " + i);
            }
        };
    }

    @Bean
    QueueChannel channel() {
        return new QueueChannel(10);
    }

    @ServiceActivator(inputChannel = "channel", poller = @Poller(fixedDelay = "0"))
    public void handle(String in) throws InterruptedException {
        Thread.sleep(1_000);
    }

    @MessagingGateway(defaultRequestChannel = "channel")
    public interface Gate {

        void send(String out);

    }

}