public class Consumer implements Runnable {
    private final Connection connection;
    private final MessageConsumer consumer;
    private final Session producerSession;
    private volatile boolean closed = false;

    public Consumer(Connection connection) {
        this.connection = connection;
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination receiveQueue = session.createQueue("BookingQueue");
        consumer = session.createConsumer(receiveQueue);
        producerSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public void close() {
        closed = true;
        connection.close();
    }

    @Override
    public void run() {
        while(!closed) {
            Message message = consumer.receive();
            Destination sendQueue = message.getJMSReplyTo();
            MessageProducer producer = producerSession.createProducer(sendQueue);
            // send message via producer
            producer.close();
        }
    }
}