public boolean queueExists(String queueName) throws Exception 
{
    final Queue managementQueue = HornetQJMSClient.createQueue("hornetq.management");
    Connection connection = jmsConnectionFactory.createConnection();
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    QueueRequestor requestor = new QueueRequestor((QueueSession) session, managementQueue);
    connection.start();
    Message message = session.createMessage();
    JMSManagementHelper.putOperationInvocation(message,
       org.hornetq.api.core.management.ResourceNames.JMS_SERVER, "getQueueNames");
    Message reply = requestor.request(message);
    Object result = JMSManagementHelper.getResult(reply);
    Object[] results = (Object[])result;
    for (int i = 0; i < results.length; i++)  
    {  
        if (queueName.equals(((String)results[i])))  
            return true;  
    }
    return false;
}