@Service
public class ConsumerService {
private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    MailSender mailSender;

    @KafkaListener(topics = "${app.topic.email}")
    public void receive(@Payload IdName data,
        @Header(KafkaHeaders.MESSAGE_KEY) String messageKey) throws Exception{
        LOG.info("Received data='{}'", data);
    }
 }