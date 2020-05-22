public class Test3 {

  private Semaphore mutex = new Semaphore(1);
  private Semaphore fillCount = new Semaphore(0);
  private Semaphore emptyCount = new Semaphore(3);

  private final List<Integer> list = new ArrayList<>();

  class Producer implements Runnable {

    private final int totalTasks;

    Producer(int totalTasks) {
      this.totalTasks = totalTasks;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < totalTasks; i++) {
          emptyCount.acquire();
          mutex.acquire();
          list.add(i);
          System.out.println("Produced: " + i);
          mutex.release();
          fillCount.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Consumer implements Runnable {
    private final int totalTasks;

    Consumer(int totalTasks) {
      this.totalTasks = totalTasks;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < totalTasks; i++) {
          fillCount.acquire();
          mutex.acquire();
          int item = list.remove(list.size() - 1);
          System.out.println("Consumed: " + item);
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
    int numConsumer = 6;
    int tasksPerConsumer = 5;

    for (int i = 0; i < numProducer; i++) {
      new Thread(new Producer(tasksPerProducer)).start();
    }
    for (int i = 0; i < numConsumer; i++) {
      new Thread(new Consumer(tasksPerConsumer)).start();
    }
  }

  public static void main(String[] args) throws IOException {
    Test3 t = new Test3();
    t.runTest();
  }
}