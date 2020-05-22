public class Test4 {

  private Semaphore mutex = new Semaphore(1);
  private Semaphore fillCount = new Semaphore(0);
  private Semaphore emptyCount = new Semaphore(3);

  private Integer EOF = Integer.MAX_VALUE;

  private final Queue<Integer> list = new LinkedList<>(); // need to put/get data in FIFO

  class Producer implements Runnable {

    private final int totalTasks;

    Producer(int totalTasks) {
      this.totalTasks = totalTasks;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < totalTasks + 1; i++) {
          emptyCount.acquire();
          mutex.acquire();
          if (i == totalTasks) {
            list.offer(EOF);
          } else {
            // add a valid value
            list.offer(i);
            System.out.println("Produced: " + i);
          }
          mutex.release();
          fillCount.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Consumer implements Runnable {

    @Override
    public void run() {
      try {
        boolean finished = false;
        while (!finished) {
          fillCount.acquire();
          mutex.acquire();
          int item = list.poll();
          if (EOF.equals(item)) {
            // do not consume this item because it means EOF
            finished = true;
          } else {
            // it's a valid value, consume it.
            System.out.println("Consumed: " + item);
          }
          mutex.release();
          emptyCount.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void runTest() {
    int numProducer = 3;
    int tasksPerProducer = 10;

    for (int i = 0; i < numProducer; i++) {
      new Thread(new Producer(tasksPerProducer)).start();
    }

    int numConsumer = numProducer; // producers will put N EOFs to kill N consumers.
    for (int i = 0; i < numConsumer; i++) {
      new Thread(new Consumer()).start();
    }
  }

  public static void main(String[] args) throws IOException {
    Test4 t = new Test4();
    t.runTest();
  }
}