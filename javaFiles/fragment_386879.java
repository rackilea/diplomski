public class TwoThreads {
  public static void main(String args[]) throws InterruptedException {
    System.out.println("TwoThreads:Test");
    new TwoThreads().test();
  }

  // The end of the list.
  private static final Integer End = -1;

  static class Producer implements Runnable {
    final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < 1000; i++) {
          queue.add(i);
          Thread.sleep(1);
        }
        // Finish the queue.
        queue.add(End);
      } catch (InterruptedException ex) {
        // Just exit.
      }
    }

  }

  static class Consumer implements Runnable {
    final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      boolean ended = false;
      while (!ended) {
        Integer i = queue.poll();
        if (i != null) {
          ended = i == End;
          System.out.println(i);
        }
      }
    }

  }

  public void test() throws InterruptedException {
    Queue<Integer> queue = new LinkedBlockingQueue<>();
    Thread pt = new Thread(new Producer(queue));
    Thread ct = new Thread(new Consumer(queue));
    // Start it all going.
    pt.start();
    ct.start();
    // Wait for it to finish.
    pt.join();
    ct.join();
  }

}