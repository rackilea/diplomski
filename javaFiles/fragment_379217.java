@Bean
public DefaultMessageListenerContainer highPriorityQueue() {
    DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
    dmlc.setConnectionFactory(connectionFactory());
    dmlc.setDestination(new ActiveMQQueue("high_priority.queue"));
    dmlc.setMessageListener(new QueueProcessor());
    dmlc.setConcurrentConsumers(50);
    return dmlc;
}

@Bean
public DefaultMessageListenerContainer medPriorityQueue() {
    DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
    dmlc.setConnectionFactory(connectionFactory());
    dmlc.setDestination(new ActiveMQQueue("med_priority.queue"));
    dmlc.setMessageListener(new QueueProcessor());
    dmlc.setConcurrentConsumers(20);
    return dmlc;
}

@Bean
public DefaultMessageListenerContainer lowPriorityQueue() {
    DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
    dmlc.setConnectionFactory(connectionFactory());
    dmlc.setDestination(new ActiveMQQueue("low_priority.queue"));
    dmlc.setMessageListener(new QueueProcessor());
    dmlc.setConcurrentConsumers(5);
    return dmlc;
}