TopicConnectionFactory topicConnectionFactory = InitialContext.doLookup("jms/RemoteConnectionFactory");
try(JMSContext jmsContext = topicConnectionFactory.createContext(<username>,<password>)) {
    Topic topic = InitialContext.doLookup(<topic>);
    JMSConsumer jmsConsumer = jmsContext.createDurableConsumer(topic, <client-id>);
    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
            jmsConsumer.close();
            this.interrupt();
        }
    });
    Message message = jmsConsumer.receive();
    if(message != null) {
        result = message.getBody(ArrayList.class);
    }
}