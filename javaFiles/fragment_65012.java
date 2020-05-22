Map<String, Object> messageHeaders = message.getHeaders();
    if (willAddHeaders(message)) {
        messageHeaders = new HashMap<>(messageHeaders);
        addHeaders(message, messageHeaders);
    }

    final Map<String, Object> headers = messageHeaders;
    final Object correlationId = message.getHeaders().getId();
    final AtomicInteger sequenceNumber = new AtomicInteger(1);

    Function<Object, AbstractIntegrationMessageBuilder<?>> messageBuilderFunction =
            object -> createBuilder(object, headers, correlationId, sequenceNumber.getAndIncrement(), sequenceSize);