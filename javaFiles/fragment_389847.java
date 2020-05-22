@SpringBootApplication
public class So44806067Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So44806067Application.class, args);
        SomeNonSingletonNeedingDistinctRequestAndReplyChannels chunker1 = context
                .getBean(SomeNonSingletonNeedingDistinctRequestAndReplyChannels.class);
        SomeNonSingletonNeedingDistinctRequestAndReplyChannels chunker2 = context
                .getBean(SomeNonSingletonNeedingDistinctRequestAndReplyChannels.class);
        if (chunker1.equals(chunker2)) {
            throw new IllegalStateException("Expected different instances");
        }
        chunker1.sendSome();
        chunker2.sendSome();
        ChunkResponse results = chunker1.getResults();
        if (results == null) {
            throw new IllegalStateException("No results1");
        }
        if (results.getJobId() != 1L) {
            throw new IllegalStateException("Incorrect routing1");
        }
        results = chunker2.getResults();
        if (results == null) {
            throw new IllegalStateException("No results2");
        }
        if (results.getJobId() != 2L) {
            throw new IllegalStateException("Incorrect routing2");
        }
        context.close();
    }

    @Bean
    public Map<Long, PollableChannel> registry() {
        // TODO: should clean up entry for jobId when job completes.
        return new ConcurrentHashMap<>();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SomeNonSingletonNeedingDistinctRequestAndReplyChannels chunker() {
        MessagingTemplate template = template();
        final PollableChannel replyChannel = replyChannel();
        SomeNonSingletonNeedingDistinctRequestAndReplyChannels bean =
                new SomeNonSingletonNeedingDistinctRequestAndReplyChannels(template, replyChannel);
        AbstractSubscribableChannel requestChannel = (AbstractSubscribableChannel) template.getDefaultDestination();
        requestChannel.addInterceptor(new ChannelInterceptorAdapter() {

            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                registry().putIfAbsent(((ChunkRequest<?>) message.getPayload()).getJobId(), replyChannel);
                return message;
            }

        });
        BridgeHandler bridge = bridge();
        requestChannel.subscribe(bridge);
        return bean;
    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MessagingTemplate template() {
        MessagingTemplate messagingTemplate = new MessagingTemplate();
        messagingTemplate.setDefaultChannel(requestChannel());
        return messagingTemplate;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DirectChannel requestChannel() {
        return new DirectChannel();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PollableChannel replyChannel() {
        return new QueueChannel();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BridgeHandler bridge() {
        BridgeHandler bridgeHandler = new BridgeHandler();
        bridgeHandler.setOutputChannel(outboundChannel());
        return bridgeHandler;
    }

    @Bean
    public DirectChannel outboundChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel masterReplyChannel() {
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "outboundChannel")
    public void simulateJmsChannelAdapterPair(ChunkRequest<?> request) {
        masterReplyChannel()
                .send(new GenericMessage<>(new ChunkResponse(request.getSequence(), request.getJobId(), null)));
    }

    @Router(inputChannel = "masterReplyChannel")
    public MessageChannel route(ChunkResponse reply) {
        // TODO: error checking - missing reply channel for jobId
        return registry().get(reply.getJobId());
    }

    public static class SomeNonSingletonNeedingDistinctRequestAndReplyChannels {

        private final static AtomicLong jobIds = new AtomicLong();

        private final long jobId = jobIds.incrementAndGet();

        private final MessagingTemplate template;

        private final PollableChannel replyChannel;

        public SomeNonSingletonNeedingDistinctRequestAndReplyChannels(MessagingTemplate template,
                PollableChannel replyChannel) {
            this.template = template;
            this.replyChannel = replyChannel;
        }

        public void sendSome() {
            ChunkRequest<String> cr = new ChunkRequest<>(0, Collections.singleton("foo"), this.jobId, null);
            this.template.send(new GenericMessage<>(cr));
        }

        public ChunkResponse getResults() {
            @SuppressWarnings("unchecked")
            Message<ChunkResponse> received = (Message<ChunkResponse>) this.replyChannel.receive(10_000);
            if (received != null) {
                if (received.getPayload().getJobId().equals(this.jobId)) {
                    System.out.println("Got the right one");
                }
                else {
                    System.out.println(
                            "Got the wrong one " + received.getPayload().getJobId() + " instead of " + this.jobId);
                }
                return received.getPayload();
            }
            return null;
        }

    }

}