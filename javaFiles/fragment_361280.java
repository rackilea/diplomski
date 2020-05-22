ConnectionFactory factory = new ActiveMQConnectionFactory(props.getProperty("mq.url"));
Connection conn  = factory.createConnection();
Session session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);
Queue queue = session.createQueue(props.getProperty("mq.source_queue"));
conn.start();
MessageConsumer consumer = session.createConsumer(queue);