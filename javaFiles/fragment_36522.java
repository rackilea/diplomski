@Test
public void test() throws Exception {
    final AtomicInteger atomicInteger = new AtomicInteger(0);

    BrokerService brokerService = new BrokerService();

    String bindAddress = "vm://localhost";
    brokerService.addConnector(bindAddress);
    brokerService.setPersistenceAdapter(new MemoryPersistenceAdapter());
    brokerService.setUseJmx(false);
    brokerService.start();

    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(bindAddress);
    RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
    redeliveryPolicy.setInitialRedeliveryDelay(500);
    redeliveryPolicy.setBackOffMultiplier(2);
    redeliveryPolicy.setUseExponentialBackOff(true);
    redeliveryPolicy.setMaximumRedeliveries(2);

    activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
    activeMQConnectionFactory.setUseRetroactiveConsumer(true);
    activeMQConnectionFactory.setClientIDPrefix("ID");

    PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(activeMQConnectionFactory);

    pooledConnectionFactory.start();

    Connection connection = pooledConnectionFactory.createConnection();
    final Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
    Queue helloQueue = session.createQueue("Hello");
    MessageConsumer consumer = session.createConsumer(helloQueue);
    consumer.setMessageListener(new MessageListener() {

        public void onMessage(Message message) {
            TextMessage textMessage = (TextMessage) message;
            try {
                switch (atomicInteger.getAndIncrement()) {
                    case 0:
                        System.out.println("OK, first message received " + textMessage.getText());
                        session.commit();
                        break;
                    case 1:
                        System.out.println("NOPE, second must be retried " + textMessage.getText());
                        session.rollback();
                        throw new RuntimeException("I failed, aaaaah");
                    case 2:
                        System.out.println("OK, second message received " + textMessage.getText());
                        session.commit();
                }
            } catch (JMSException e) {
                e.printStackTrace(System.out);
            }
        }
    });
    connection.start();

    {
        // A client sends two messages...
        Connection connection1 = pooledConnectionFactory.createConnection();
        Session session1 = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection1.start();

        MessageProducer producer = session1.createProducer(helloQueue);
        producer.send(session1.createTextMessage("Hello World 1"));
        producer.send(session1.createTextMessage("Hello World 2"));

        producer.close();
        session1.close();
        connection1.stop();
        connection1.close();
    }
    JOptionPane.showInputDialog("I will wait, you watch the log...");

    consumer.close();
    session.close();
    connection.stop();
    connection.close();
    pooledConnectionFactory.stop();

    assertEquals(3, atomicInteger.get());
}