public class Test {
  // Special stop message to tell the worker to stop.
  public static final Message Stop = new Message("Stop!");

  static class Message {
    final String msg;

    // A message to a worker.
    public Message(String msg) {
      this.msg = msg;
    }

    public String toString() {
      return msg;
    }

  }

  class Worker implements Runnable {
    private volatile boolean stop = false;
    private final BlockingQueue<Message> workQueue;

    public Worker(BlockingQueue<Message> workQueue) {
      this.workQueue = workQueue;
    }

    @Override
    public void run() {
      while (!stop) {
        try {
          Message msg = workQueue.poll(10, TimeUnit.SECONDS);
          // Handle the message ...

          System.out.println("Worker " + Thread.currentThread().getName() + " got message " + msg);
          // Is it my special stop message.
          if (msg == Stop) {
            stop = true;
          }
        } catch (InterruptedException ex) {
          // Just stop on interrupt.
          stop = true;
        }
      }
    }
  }

  Map<Integer, BlockingQueue<Message>> queues = new HashMap<>();

  public void test() throws InterruptedException {
    // Keep track of my threads.
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      // Make the queue for it.
      BlockingQueue<Message> queue = new ArrayBlockingQueue(10);
      // Build its thread, handing it the queue to use.
      Thread thread = new Thread(new Worker(queue), "Worker-" + i);
      threads.add(thread);
      // Store the queue in the map.
      queues.put(i, queue);
      // Start the process.
      thread.start();
    }

    // Test one.
    queues.get(5).put(new Message("Hello"));

    // Close down.
    for (BlockingQueue<Message> q : queues.values()) {
      // Stop each queue.
      q.put(Stop);
    }

    // Join all threads to wait for them to finish.
    for (Thread t : threads) {
      t.join();
    }
  }

  public static void main(String args[]) {
    try {
      new Test().test();
    } catch (Throwable t) {
      t.printStackTrace(System.err);
    }
  }

}