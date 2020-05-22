kafkaStream.setStateListener((newState, oldState) -> {
    log.info("Kafka stream state changed [{}] >>>>> [{}]", oldState, newState);
    if (newState == KafkaStreams.State.ERROR || newState == KafkaStreams.State.PENDING_SHUTDOWN) {
        log.error("Kafka Stream is in [{}] state. Application should be restarted", newState);
    }
});