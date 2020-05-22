public AntMessage sendBlocking(AntBlockingMessage requestMessage) {
        Flux<AntMessage> response = this.antUsbReader.antMessages()
                .filter(responseMessage -> isMatchingResponse(requestMessage, responseMessage))
                .take(1);

        Mono<Void> messageSender = Mono.fromRunnable(() -> this.antUsbWriter.write(requestMessage));
        return (AntMessage) Flux.merge(response, messageSender).blockFirst(Duration.ofSeconds(1));
    }

    private boolean isMatchingResponse(AntBlockingMessage message, AntMessage response) {
        if (message instanceof RequestMessage) {
            return response.getMessageId() == ((RequestMessage) message).getMsgIdRequested();
        }
        return response.getMessageId() == message.getMessageId();
    }