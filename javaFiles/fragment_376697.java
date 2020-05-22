@Value("${spring.rabbitmq.port}")
private int mqPort;

@Value("${spring.rabbitmq.host}")
private String mqHost;

@Autowired
public UnitAmqpRestController(RabbitTemplate rabbitTemplate) throws IOException, TimeoutException {
    this.rabbitTemplate = rabbitTemplate;
    rabbitTemplate.setReplyTimeout(15_000L);
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(mqHost);
    factory.setPort(mqPort);
    connection = factory.newConnection();
    channel = connection.createChannel();
}