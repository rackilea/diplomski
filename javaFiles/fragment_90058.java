public class Test {

private Semaphore semaphore = new Semaphore(1); // Allow max 1 'palyer'

public static void main(String[] args) {
    Test t = new Test();
    t.start(1);
    t.start(2);
    t.start(3);
    t.start(4);
}

private void start(int i) {
    try {
        semaphore.acquire();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("start " + i);
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            stop(i);
        }
    };
    new Thread(runnable).start();
}

private void stop(int i) {
    System.out.println("stop " + i);
    semaphore.release();
}
}