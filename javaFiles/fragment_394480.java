ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
JmsTemplate t = new JmsTemplate(cf);
t.send("test", new MessageCreator() {
  public Message createMessage(Session session) throws JMSException {
    return session.createTextMessage("test");
  }
});