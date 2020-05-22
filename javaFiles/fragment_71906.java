public class MessagesRunner {

    public static void main(String[] args) {
        // Adjusted - Used builder instead of constructor
        CommandBus commandBus = SimpleCommandBus.builder().build();

        // Adjusted - Used builder instead of constructor
        CommandGateway commandGateway = DefaultCommandGateway.builder()
                .commandBus(commandBus)
                .build();

        // Adjusted - Used builder instead of constructor
        EventStore eventStore = EmbeddedEventStore.builder()
                .storageEngine(new InMemoryEventStorageEngine())
                .build();

        // Adjusted - Used builder instead of constructor
        EventSourcingRepository<MessagesAggregate> repository =
                EventSourcingRepository.builder(MessagesAggregate.class)
                        .eventStore(eventStore)
                        .build();


        // Adjusted - Used builder instead of constructor
        AggregateAnnotationCommandHandler<MessagesAggregate> messagesAggregateAggregateAnnotationCommandHandler =
                AggregateAnnotationCommandHandler.<MessagesAggregate>builder()
                        .aggregateType(MessagesAggregate.class)
                        .repository(repository)
                        .build();

        messagesAggregateAggregateAnnotationCommandHandler.subscribe(commandBus);

        // Adjusted - Renamed AnnotationEventListenerAdapter to AnnotationEventHandlerAdapter
        final AnnotationEventHandlerAdapter annotationEventListenerAdapter =
                new AnnotationEventHandlerAdapter(new MessagesEventHandler());
        eventStore.subscribe(eventMessages -> eventMessages.forEach(e -> {
                    try {
                        annotationEventListenerAdapter.handle(e);
                    } catch (Exception e1) {
                        throw new RuntimeException(e1);

                    }
                }

        ));

        final String itemId = UUID.randomUUID().toString();
        commandGateway.send(new CreateMessageCommand(itemId, "Hello, how is your day? :-)"));
        commandGateway.send(new MarkReadMessageCommand(itemId));
    }
}