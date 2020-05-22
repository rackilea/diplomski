@RunWith(SpringRunner.class)
@DirtiesContext
public class So47264688Tests {

    private static final String MESSAGE_GROUP = "transactionalQueueChannel";

    private static EmbeddedDatabase dataSource;

    @BeforeClass
    public static void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/org/springframework/integration/jdbc/schema-drop-h2.sql")
                .addScript("classpath:/org/springframework/integration/jdbc/schema-h2.sql")
                .build();
    }

    @AfterClass
    public static void destroy() {
        dataSource.shutdown();
    }

    @Autowired
    private PollableChannel transactionalQueueChannel;

    @Autowired
    private JdbcChannelMessageStore jdbcChannelMessageStore;

    @Autowired
    private PollingConsumer serviceActivatorEndpoint;

    @Autowired
    private CountDownLatch exceptionLatch;

    @Test
    public void testTransactionalQueueChannel() throws InterruptedException {
        GenericMessage<String> message = new GenericMessage<>("foo");
        this.transactionalQueueChannel.send(message);

        assertTrue(this.exceptionLatch.await(10, TimeUnit.SECONDS));
        this.serviceActivatorEndpoint.stop();

        assertEquals(1, this.jdbcChannelMessageStore.messageGroupSize(MESSAGE_GROUP));
        Message<?> messageFromStore = this.jdbcChannelMessageStore.pollMessageFromGroup(MESSAGE_GROUP);

        assertNotNull(messageFromStore);
        assertEquals(message, messageFromStore);
    }

    @Configuration
    @EnableIntegration
    public static class ContextConfiguration {

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean
        public ChannelMessageStoreQueryProvider queryProvider() {
            return new H2ChannelMessageStoreQueryProvider();
        }

        @Bean
        public JdbcChannelMessageStore jdbcChannelMessageStore() {
            JdbcChannelMessageStore jdbcChannelMessageStore = new JdbcChannelMessageStore(dataSource);
            jdbcChannelMessageStore.setChannelMessageStoreQueryProvider(queryProvider());
            return jdbcChannelMessageStore;
        }

        @Bean
        public PollableChannel transactionalQueueChannel() {
            return new QueueChannel(new MessageGroupQueue(jdbcChannelMessageStore(), MESSAGE_GROUP));
        }

        @Bean
        public TransactionInterceptor transactionInterceptor() {
            return new TransactionInterceptorBuilder()
                    .transactionManager(transactionManager())
                    .isolation(Isolation.READ_COMMITTED)
                    .propagation(Propagation.REQUIRED)
                    .build();
        }

        @Bean
        public TaskExecutor threadPoolTaskExecutor() {
            ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
            threadPoolTaskExecutor.setCorePoolSize(5);
            return threadPoolTaskExecutor;
        }

        @Bean(name = PollerMetadata.DEFAULT_POLLER)
        public PollerMetadata poller() {
            return Pollers.fixedDelay(10)
                    .advice(transactionInterceptor())
                    .taskExecutor(threadPoolTaskExecutor())
                    .get();
        }

        @Bean
        public CountDownLatch exceptionLatch() {
            return new CountDownLatch(2);
        }

        @ServiceActivator(inputChannel = "transactionalQueueChannel")
        public void handle(Message<?> message) {
            System.out.println(message);
            try {
                throw new RuntimeException("Intentional for rollback");
            }
            finally {
                exceptionLatch().countDown();
            }
        }

    }

}