public DirectJMSRemotingClient() throws JMSException {
    factory = new ActiveMQConnectionFactory(brokerURL);
    connection = factory.createConnection();
    connection.start();
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    Destination destination = session.createQueue("queueName");
    producer = session.createProducer(destination);
}

public void sendMessage() throws JMSException {

    TextMessage myTextMsg = session.createTextMessage();

    myTextMsg.setText("Hello World");
    System.out.println("Sending Message: " + myTextMsg.getText());
    producer.send(myTextMsg);
}

public static void main(String[] args) throws Exception {
    DirectJMSRemotingClient client = new DirectJMSRemotingClient();
    client.sendMessage();
}