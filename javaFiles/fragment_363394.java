public static void main(String[] args) throws InterruptedException, JMSException {

//Create a Consumer with coresize 4 and Max size 10
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 100, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.allowCoreThreadTimeOut(true);

        for (int i = 0; i <count; i++) {
            executor.execute(new Consumer(queue));
        }

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
        while ((str = queue.poll()) == null) {
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        System.out.println("Removed: " + str);
        //}
    }