url = "vm://localhost:61616"    //if you are in same jvm
url2 = "tcp://localhost:61616"   //if you are in diff jvm or other host
connectionFactory = new ActiveMQConnectionFactory(username,password,url);
connection = (ActiveMQConnection) connectionFactory.createConnection();
connection.start();
session = connection.createSession(transacted, ackMode);