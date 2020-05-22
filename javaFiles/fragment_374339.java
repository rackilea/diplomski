Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL,
                "tcp://localhost:61616");
        props.put("topic." + "TOPICNAME", "TOPICNAME");
        InitialContext ic = new InitialContext(props);
        ConnectionFactory cf1 = (ConnectionFactory) ic.lookup("ConnectionFactory");
        writeDestination = (Topic) ic.lookup("TOPICNAME");
        writeDestConnection = cf1.createConnection("user", "pwd");
        writeDestConnection.setClientID("durableSubscriber_" + "TOPICNAME");
        writeDestSession = writeDestConnection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        writeDestProducer = writeDestSession.createProducer(writeDestination);
        writeDestConnection.start();
        TextMessage message = writeDestSession.createTextMessage(json);
        message.setStringProperty("clientID", "ifYouNeed");
        writeDestProducer.send(message);