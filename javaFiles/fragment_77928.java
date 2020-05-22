Destination advisoryDestination = AdvisorySupport.getExpiredQueueMessageAdvisoryTopic(destination)
MessageConsumer consumer = session.createConsumer(advisoryDestination);
consumer.setMessageListener(this);

public void onMessage(Message msg){
    String messageId =   msg.getJMSMessageID();
    String orignalMessageId =   msg.getStringProperty(org.apache.activemq.advisory.AdvisorySupport.MSG_PROPERTY_MESSAGE_ID);
    if (msg instanceof ActiveMQMessage){
        try {
             ActiveMQMessage aMsg =  (ActiveMQMessage)msg;
             ProducerInfo prod = (ProducerInfo) aMsg.getDataStructure();
        } catch (JMSException e) {
            log.error("Failed to process message: " + msg);
        }
    }
}