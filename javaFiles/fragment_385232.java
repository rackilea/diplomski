public class DestinationThread extends Thread {

    private String destinationQueue;

    private static ActiveMQConnectionFactory connectionFactory = null;
    private static Connection connection = null;
    private static Session session = null;
    private static Destination destination = null;
    private static MessageConsumer consumer = null;

    public DestinationThread(String destinationQueue) {
        this.destinationQueue = destinationQueue;
    }

    @Override
    public void run() {
        try {
                initializeThread(destinationQueue);
                startThread(destinationQueue);
        } catch (Exception e) {
            //TODO
        }
    }

    private void initializeThread(String destinationQueue) {
        boolean connectionMade = false;
        while (!connectionMade) {
            try {
                connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
                connection = connectionFactory.createConnection();
                connection.start();
                session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
                destination = session.createQueue(destinationQueue);
                consumer = session.createConsumer(destination);
                connectionMade = true;
            } catch (JMSException e) {
                //TODO
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ie) {
                }
            }
        }
    }


    private void startThreadOther(String destinationQueue) throws Exception {
        while (true) {
            try {
                Message message = consumer.receive(300000);
                if (message == null) {
                    //No message received for 5 minutes - Re-initializing the connection
                    initializeThread(destinationQueue);
                } else if (message instanceof TextMessage) {
                    if (destinationQueue.equals("queue1") {
                        //Message received from queue1 - do something with it
                    } else if (destinationQueue.equals("queue2") {
                        //Message received from queue2 - do something with it
                    } else {
                        //nothing
                    }
                } else {
                    //nothing
                }
            } catch (Exception e) {
                //TODO
            }
        }
    }
}