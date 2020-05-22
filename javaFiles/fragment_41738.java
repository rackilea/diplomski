class SharedValueHolder {
  public static int counter = 0;
}

class Incrementor implements Runnable {
  public void run() {
    for (int i = 0; i < 100000; i++) {
      SharedValueHolder.counter++;
    }
  }
}

public class ThreadTest {
  public static void main(String... args) throws InterruptedException {
    Thread thread1 = new Thread(new Incrementor());
    Thread thread2 = new Thread(new Incrementor());
    thread1.start();
    thread2.start();

    Thread.sleep(2000);
    System.out.println(SharedValueHolder.counter);
  }
}