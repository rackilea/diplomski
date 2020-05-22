@SpringBootApplication
public class So58804826Application {

    public static void main(String[] args) {
        SpringApplication.run(So58804826Application.class, args);
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }


    @Bean
    public ChainedKafkaTransactionManager<?, ?> chainedTxM(JpaTransactionManager jpa,
            KafkaTransactionManager<?, ?> kafka) {

        kafka.setTransactionSynchronization(SYNCHRONIZATION_ON_ACTUAL_TRANSACTION);
        return new ChainedKafkaTransactionManager<>(kafka, jpa);
    }

    @Autowired
    private Saver saver;

    @KafkaListener(id = "so58804826", topics = "so58804826")
    public void listen(String in) {
        System.out.println("Storing: " + in);
        this.saver.save(in);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("so58804826")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
//          template.executeInTransaction(t -> t.send("so58804826", "foo"));
        };
    }

}

@Component
class ContainerFactoryConfigurer {

    ContainerFactoryConfigurer(ConcurrentKafkaListenerContainerFactory<?, ?> factory,
            ChainedKafkaTransactionManager<?, ?> tm) {

        factory.getContainerProperties().setTransactionManager(tm);
        factory.setAfterRollbackProcessor(new DefaultAfterRollbackProcessor<>(new FixedBackOff(1000L, 3)));
    }

}

@Component
class Saver {

    @Autowired
    private MyEntityRepo repo;

    private final AtomicInteger ids = new AtomicInteger();

    @Transactional("chainedTxM")
    public void save(String in) {
        this.repo.save(new MyEntity(in, this.ids.incrementAndGet()));
        throw new RuntimeException("foo");
    }

}