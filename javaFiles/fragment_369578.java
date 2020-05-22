public class AkkademyDB extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    protected final Map<String, Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(SetRequest.class, message -> {
                log.info("Received set request-key:{} value: {}", message.getKey(), message.getValue());
                map.put(message.getKey(), message.getValue()); // <--- put in map
            })
            .matchAny(o -> log.info("received unknown message {}", o))
            .build();
    }
}