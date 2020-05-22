public static void main(String[] args) throws InterruptedException, JMSException {

//Create a Consumer with coresize 4 and Max size 10
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 100, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.allowCoreThreadTimeOut(true);

        **//INITIALIZE ACTIVEMQ CONFIGURATION HERE**

        consumer.setMessageListener(new QueueMessageListener());
        executor.shutdown();
    }

private static class QueueMessageListener implements MessageListener {

            @Override
            public void onMessage(Message message) {
                executor.execute(new Consumer((TextMessage) message));
            }
        }
    }

//Problem here unable to consume
class Consumer implements Runnable {
    TextMessage textMessage;

    public Consumer(TextMessage textMessage) {
        this.textMessage = textMessage;
    }
    public void run() {
        System.out.println("Removed: " + str);
    }
}