@Override
public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
    List<QueueInformation> queueInformationList = consumersStatic.getQueueInformationList();
    int i = 0;
    for (QueueInformation queueInformation :
            queueInformationList) {
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
        endpoint.setId("myJmsEndpoint-" + i++);
        endpoint.setDestination(queueInformation.getMqQueueName());
        endpoint.setMessageListener(message -> {
            logger.debug("***********************************************receivedMessage:" + message);
        });
        registrar.registerEndpoint(endpoint);
        logger.debug("registered the endpoint for queue" + queueInformation.getMqQueueName());
    }

}