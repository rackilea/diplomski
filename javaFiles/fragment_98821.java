/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow_4615895;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

public class Dispatcher {

    private static long QUEUE_WAIT_TIME = 1000;
    private boolean mStop = false;
    private QueueConnectionFactory mFactory;
    private String mSourceQueueName;
    private String[] mConsumerQueueNames;

    /**
     * Create a dispatcher
     * @param factory
     *      The QueueConnectionFactory in which new connections, session, and consumers
     *      will be created. This is needed to ensure the connection is associated
     *      with the correct thread.
     * @param source
     *
     * @param consumerQueues
     */
    public Dispatcher(
        QueueConnectionFactory factory, 
        String sourceQueue, 
        String[] consumerQueues) {

        mFactory = factory;
        mSourceQueueName = sourceQueue;
        mConsumerQueueNames = consumerQueues;
    }

    public void start() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                Dispatcher.this.run();
            }
        });
        thread.setName("Queue Dispatcher");
        thread.start();
    }

    public void stop() {
        mStop = true;
    }

    private void run() {

        QueueConnection connection = null;
        MessageProducer producer = null;
        MessageConsumer consumer = null;
        QueueSession session = null;
        try {
            // Setup connection and queues for receiving the messages
            connection = mFactory.createQueueConnection();
            session = connection.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
            Queue sourceQueue = session.createQueue(mSourceQueueName);
            consumer = session.createConsumer(sourceQueue);

            // Create a null producer allowing us to send messages
            // to any queue.
            producer = session.createProducer(null);

            // Create the destination queues based on the consumer names we
            // were given.
            Queue[] destinationQueues = new Queue[mConsumerQueueNames.length];
            for (int index = 0; index < mConsumerQueueNames.length; ++index) {
                destinationQueues[index] = session.createQueue(mConsumerQueueNames[index]);
            }

            connection.start();

            while (!mStop) {

                // Only wait QUEUE_WAIT_TIME in order to give
                // the dispatcher a chance to see if it should
                // quit
                Message m = consumer.receive(QUEUE_WAIT_TIME);
                if (m == null) {
                    continue;
                }

                // Take the message we received and put
                // it in each of the consumers destination
                // queues for them to process
                for (Queue q : destinationQueues) {
                    producer.send(q, m);
                }
            }

        } catch (JMSException ex) {
            // Do wonderful things here 
        } finally {
            if (producer != null) {
                try {
                    producer.close();
                } catch (JMSException ex) {
                }
            }
            if (consumer != null) {
                try {
                    consumer.close();
                } catch (JMSException ex) {
                }
            }
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                }
            }
        }
    }
}