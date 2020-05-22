@SpringBootApplication
public class So54365437Application {

    private static final Logger logger = LoggerFactory.getLogger(So54365437Application.class);

    public static void main(String[] args) {
        SpringApplication.run(So54365437Application.class, args).close();
    }

    private final AtomicInteger lCount = new AtomicInteger();

    private final AtomicInteger mCount = new AtomicInteger();

    private final AtomicInteger iCount = new AtomicInteger();

    private final AtomicLong t0 = new AtomicLong();

    @RabbitListener(queues = "foo")
    public void listener(Integer in) {
        int n = lCount.incrementAndGet();
        if (n % 100 == 0) {
            logger.info("listener @" + n);
        }
        if (n == 2000) {
            logger.info("listener done @" + rate());
        }
    }

    @Bean
    public DirectMessageListenerContainer container(final DirectRabbitListenerContainerFactory containerFactory) {
        final DirectMessageListenerContainer listenerContainer = containerFactory.createListenerContainer();
        listenerContainer.setQueueNames("bar");
        listenerContainer.setAutoStartup(false);
        listenerContainer.setMessageListener(m -> {
            int n = mCount.incrementAndGet();
            if (n % 100 == 0) {
                logger.info("manual @" + n);
            }
            if (n == 2000) {
                logger.info("manual done @" + rate());
            }
        });
        return listenerContainer;
    }

    @Bean
    public DirectMessageListenerContainer integrationContainer(final DirectRabbitListenerContainerFactory containerFactory) {
        final DirectMessageListenerContainer listenerContainer = containerFactory.createListenerContainer();
        listenerContainer.setQueueNames("baz");
        listenerContainer.setAutoStartup(false);
        return listenerContainer;
    }

    @Bean
    public IntegrationFlow demoFlow(final DirectMessageListenerContainer integrationContainer) {
        return IntegrationFlows.from(Amqp.inboundGateway(integrationContainer).autoStartup(false))
                .handle(p -> {
                    int n = iCount.incrementAndGet();
                    if (n % 100 == 0) {
                        logger.info("integration @" + n);
                    }
                    if (n == 2000) {
                        logger.info("integration done @" + rate());
                    }
                })
                .get();
    }

    private String rate() {
        return "" + 2000000.0 / ((System.currentTimeMillis() - t0.get())) + "/sec";
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template, RabbitListenerEndpointRegistry registry,
            DirectMessageListenerContainer container, DirectMessageListenerContainer integrationContainer) {

        return args -> {
            IntStream.range(0, 2000)
                .forEach(i -> {
                    switch(args.getSourceArgs()[1]) {
                    case "listener":
                        template.convertAndSend("foo", i);
                        break;
                    case "manual":
                        template.convertAndSend("bar", i);
                        break;
                    case "integration":
                        template.convertAndSend("baz", i);
                        break;
                    }
                });
            logger.info("All sent; starting container");
            t0.set(System.currentTimeMillis());
            switch(args.getSourceArgs()[1]) {
            case "listener":
                registry.start();
                break;
            case "manual":
                container.start();
                break;
            case "integration":
                integrationContainer.start();
                break;
            }
            System.in.read();
        };
    }

}