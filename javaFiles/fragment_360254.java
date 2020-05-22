public static void consumeMessage(String user, String queueName) {  
  Queue queue;
  try {
   QueueConnection QCon = getConnection();  
   Session session = QCon.createQueueSession(false,Session.CLIENT_ACKNOWLEDGE);
   QCon.start();
   queue = ((AQjmsSession) session).getQueue(user, queueName);
   MessageConsumer consumer = session.createConsumer(queue);
   TextMessage msg = (TextMessage) consumer.receive();
   System.out.println("MESSAGE RECEIVED " + msg.getText());

   consumer.close();
   session.close();
   QCon.close();
  } catch (JMSException e) {  
   e.printStackTrace();
  }
 }