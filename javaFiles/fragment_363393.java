public static void main(String[] args) throws InterruptedException, JMSException {

//Create a producer
// 1- settext.getTextmessage() == null i suppose at this level, see 2- point
        Thread producer = new Thread(new Producer(queue,settext));
        producer.start();
//Create a Consumer with coresize 4 and Max size 10
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 100, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.allowCoreThreadTimeOut(true);

        // 3- you start consumers go to 4, note that you will only consume count messages !!
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
                //Setting the text message to a setter which takes TextMessage as arg
                settext.setTextmessage((TextMessage) message);
                // at this point message is considered as delivered if sessionAcknowledgeModeName is AUTO_ACKNOWLEDGE and maybe lost if asynchronous treatment fails
            }
        }
    }

 //Problem here unable to produce
class Producer implements Runnable {

    ConcurrentLinkedQueue<TextMessage> queue;
    Settext settext;
    Producer(ConcurrentLinkedQueue<TextMessage> queue2, Settext settext){
        this.queue = queue2;
        this.settext=settext;
    }

    public void run() {
        System.out.println("Producer Started");
        try {
        // 2- settext.getTextmessage() == null if block is not executed and thread will sleep and finish
    // you have to add this         
            while (this.settext.getTextmessage() == null) {
            try {
                Thread.currentThread().sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
            if(this.settext.getTextmessage()!=null)
            {
               //Add to ConcurrentLinkedQueue
                queue.add(this.settext.getTextmessage());
            }
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
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
        // 4- queue.poll() == null at this level, while loop finished, thread will sleep and finish
    // you have to add this
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