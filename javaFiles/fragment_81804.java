@KafkaListener(topics = "test", containerFactory = "kafkaListenerContainerFactory")
public void handleEvent(BasicEvent event) {

    if (event instanceof EventOne) {
        logger.info("type={EventOne}, event={}", event);
    } else {
        logger.info("type={EventTwo}, event={}", event);
    }
}