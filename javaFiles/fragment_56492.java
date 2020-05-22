Connection connection = null;
Session session = null;
Formatter formatter = new Formatter();
Map<String, Object> connectionParams = new HashMap<String, Object>();
connectionParams.put(TransportConstants.PORT_PROP_NAME, 5445);
connectionParams.put(TransportConstants.HOST_PROP_NAME, "localhost");

TransportConfiguration transportConfiguration = new TransportConfiguration(
    NettyConnectorFactory.class.getName(), connectionParams);

try {
    HornetQConnectionFactory cf = HornetQJMSClient
        .createConnectionFactoryWithHA(JMSFactoryType.CF, transportConfiguration);

    connection = cf.createConnection("testuser", "testpassword");

    connection.start();
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    Topic topicTarifas = session.createTopic("tarifas.01101");
    MessageProducer producer = session.createProducer(topicTarifas);

    Message message = session.createTextMessage("My Test Message");

    producer.send(message);

    System.out.println("It Worked!");
} catch (Exception e) {
    System.out.println("It Failed!");
    e.printStackTrace();
}