@Service
@Primary
@Transactional
public class NullHeaderAwareMessageService extends MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public NullHeaderAwareMessageService(MessageRepository messageRepository) {
        super(messageRepository);

        this.messageRepository = messageRepository;
    }

    @Override
    public Message saveMessage(Message.Direction direction, String payload, String citrusMessageId, Map<String, Object> headers) {
        Message message = new Message();
        message.setDate(new Date());
        message.setDirection(direction);
        message.setPayload(payload);
        message.setCitrusMessageId(citrusMessageId);
        if (headers != null) {
            headers.entrySet().stream()
                    .filter(headerEntry -> headerEntry.getValue() != null)
                    .forEach(headerEntry -> message.addHeader(
                                new MessageHeader(headerEntry.getKey(),
                                        StringUtils.abbreviate(headerEntry.getValue().toString(), 255))));
        }

        return messageRepository.save(message);
    }
}