public static void main(String[] args) throws InterruptedException, JMSException {

    new Consumer(queue).start();

    **//INITIALIZE ACTIVEMQ CONFIGURATION HERE**

    consumer.setMessageListener(new QueueMessageListener());
    executor.shutdown();
}

private static class QueueMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        queue.add((TextMessage) message);
    }
}

//Problem here unable to consume
class Consumer implements Runnable {
    ConcurrentLinkedQueue<TextMessage> queue;

    public Consumer(ConcurrentLinkedQueue<TextMessage> queue2) {
        this.queue = queue2;
    }
    public void run() {
        TextMessage str;
        System.out.println("Consumer Started");
        while (true) {
            try {
                Thread.currentThread().sleep(500);
            } catch (Exception ex) {
            }
            while ((str = queue.poll()) == null) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (Exception ex) {
                }
            }
            System.out.println("Removed: " + str);
        }
    }
}