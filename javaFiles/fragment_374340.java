public static void main(String[] args) throws JMSException {
    Connection conn = null;
    try {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        conn = cf.createConnection("user", "pwd");
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue("queueName"));
        conn.start();
        TextMessage msg = null;
        while ((msg = (TextMessage) consumer.receive()) != null) {
            System.out.println("Received message is: " + msg.getText());
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}