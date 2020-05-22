Queue queue = session.createQueue("shared");
Queue responseQueue = session.createTemporaryQueue();
Message message = session.createMessage();
message.setJMSReplyTo(responseQueue);
...
session.commit();
...
MessageConsumer responseConsumer = session.createConsumer(responseQueue);
Message response = responseConsumer.receive();
...
session.close();