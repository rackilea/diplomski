class Stater {

public static boolean STOP = false;
private Producer producer;
private Consumer consumer;
private ExecutorService producerService= Executors.newFixedThreadPool(PRODUCER_NUMBER, taxiFactory);
private ExecutorService consumerService= Executors.newFixedThreadPool(CONSUMER_NUMBER, clientFactory);

 private void working() {

    for (int i = 0; i < PRODUCER_NUMBER; i++) {
        producerService.execute(() -> producer.get());
        consumerService.execute(() -> consumer.run());
    }

    Starter.STOP = true;
    producerService.shutdown();
    consumerService.shutdown();
 }
}


class Common {

private Queue<Message> emergencyQueue;
private BlockingQueue<Message> blockingQueue;

   public void insertOrder(Message message) {
        if (!blockingQueue.offer(message)) {
            emergencyQueue.add(message);
        }
    }

   public Message getOrder() {

        if (emergencyQueue.isEmpty()) {
            if (!blockingQueue.isEmpty()) {
                return blockingQueue.poll();
            } else {
                return null;
            }
        } else {
            return emergencyQueue.poll();
        }
    }

   public boolean shouldStop() {
        return blockingQueue.isEmpty() && emergencyQueue.isEmpty() && Starter.STOP;
    }   
}


class Consumer implements Runnable{

private Common common;

   public void run(){
       common.insertOrder(new Message());
    }
}

class Producer implements Runnable{

private Common common;

   public void run(){

          while (!common.shouldStop()) {

              Message message=common.getOrder();

              if (message == null) {
               Thread.sleep(new Random().nextInt(TIME_TO_WAIT));
            }

          }
    }
}