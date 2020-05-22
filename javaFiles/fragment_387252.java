@Service
public class ConsumerService {
private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    MailSender mailSender;

    @KafkaListener(topics = "${app.topic.email}")
    public void receive(@Payload IdName data,
        @Headers MessageHeaders headers) throws Exception{
        LOG.info("Received data='{}'", data);
    }
 }