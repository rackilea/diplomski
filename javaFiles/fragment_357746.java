javax.jms.Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;


        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        connection = connectionFactory.createConnection();
        connection.start();


        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue(queueName);


        consumer = session.createConsumer(destination);
        consumer.setMessageListener(new YourClass());