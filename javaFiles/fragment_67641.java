@SpringBootApplication
@EnableBinding(Processor.class)
public class So57379575Application {

    public static void main(String[] args) {
        SpringApplication.run(So57379575Application.class, args);
    }

    @Autowired
    private MessageChannel output;

    @StreamListener(Processor.INPUT)
    public void listen(String in) {
        System.out.println("in:" + in);
        this.output.send(new GenericMessage<>(in.toUpperCase()));
        if (in.equals("two")) {
            throw new RuntimeException("fail");
        }
    }

    @KafkaListener(id = "so57379575", topics = "so57379575out")
    public void listen2(String in) {
        System.out.println("out:" + in);
    }

    @KafkaListener(id = "so57379575DLT", topics = "so57379575dlt")
    public void listen3(String in) {
        System.out.println("dlt:" + in);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<byte[], byte[]> template) {
        return args -> {
            template.send("so57379575in", "one".getBytes());
            template.send("so57379575in", "two".getBytes());
        };
    }

    @Bean
    public ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> customizer(
            KafkaTemplate<Object, Object> template) {

        return (container, dest, group) -> {
            // enable transaction synchronization
            KafkaTransactionManager<?, ?> tm = (KafkaTransactionManager<?, ?>) container.getContainerProperties()
                    .getTransactionManager();
            tm.setTransactionSynchronization(AbstractPlatformTransactionManager.SYNCHRONIZATION_ON_ACTUAL_TRANSACTION);
            // container dead-lettering
            DefaultAfterRollbackProcessor<? super byte[], ? super byte[]> afterRollbackProcessor =
                    new DefaultAfterRollbackProcessor<>(new DeadLetterPublishingRecoverer(template,
                            (ex, tp) -> new TopicPartition("so57379575dlt", -1)), 0);
            container.setAfterRollbackProcessor(afterRollbackProcessor);
        };
    }

}