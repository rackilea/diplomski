@SpringBootApplication
public class So53206036Application {

    public static void main(String[] args) {
        SpringApplication.run(So53206036Application.class, args);
    }

    @Bean
    public MultiReplyTemplate rabbitTemplate(ConnectionFactory cf) {
        MultiReplyTemplate template = new MultiReplyTemplate();
        template.setConnectionFactory(cf);
        template.setMessageConverter(listConverter());
        return template;
    }

    @Bean
    public ListConverter listConverter() {
        return new ListConverter(new SimpleMessageConverter());
    }

    @RabbitListener(queues = "foo")
    public String listen1(String in) {
        return in.toUpperCase();
    }

    @RabbitListener(queues = "bar")
    public String listen2(String in) {
        return in + in;
    }

    @Bean
    public ApplicationRunner runner(MultiReplyTemplate template) {
        return args -> {
            List<String> reply = template.convertSendAndReceiveAsType("fanout", "", "foo",
                    new ParameterizedTypeReference<List<String>>() { });
            System.out.println(reply);
        };
    }

}

class MultiReplyTemplate extends RabbitTemplate {

    private static final byte[] NOBODY = new byte[0];

    private final Map<String, Message> replies = new HashMap<>();

    @Override
    public void onMessage(Message message) {
        // Not thread-safe but that's ok since the DRTMLC is single-threadded.
        String corr = message.getMessageProperties().getCorrelationId();
        Message combined = this.replies.get(corr);
        if (combined == null) {
            combined = new Message(NOBODY, new MessageProperties());
            combined.getMessageProperties().getHeaders().put("replies", new ArrayList<Message>());
            this.replies.put(corr, combined);
        }
        @SuppressWarnings("unchecked")
        List<Message> list = (List<Message>) combined.getMessageProperties().getHeaders().get("replies");
        list.add(message);
        if (list.size() == 2) {
            this.replies.remove(corr);
            combined.getMessageProperties().setCorrelationId(corr);
            super.onMessage(combined);
        }
    }

}

class ListConverter implements SmartMessageConverter {

    private final MessageConverter delegate;

    ListConverter(MessageConverter delegate) {
        this.delegate = delegate;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        return this.delegate.toMessage(object, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        return this.delegate.fromMessage(message); // for listeners
    }

    @Override
    public Object fromMessage(Message message, Object conversionHint) throws MessageConversionException {
        @SuppressWarnings({ "unchecked" })
        List<Message> list = (List<Message>) message.getMessageProperties().getHeaders().get("replies");
        return list.stream()
                .map(m -> this.delegate.fromMessage(m))
                .collect(Collectors.toList());
    }

}