public class Main {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "TestQueue";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination); 
        String xml = readXmlFromFile();
        TextMessage message = session.createTextMessage(xml);
        producer.send(message);
        connection.close();
    }

    private static String readXmlFromFile() {
        // read XML from file
    }
}