jmsTemplate.convertAndSend("product.topic", product, new MessagePostProcessor() {
        @Override
        public Message postProcessMessage(Message message) throws JMSException {
            message.setStringProperty("my_property", "my_value");
            return message;
        }
    });