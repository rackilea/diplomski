template.convertAndSend("exchange", "routingKey", "message", new MessagePostProcessor() {

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().setPriority(5);
        return message;
    }
});