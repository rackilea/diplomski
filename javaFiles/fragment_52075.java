public class ThreadExample implements Runnable {
    public static void main(String args[]) {
        System.out.println("A");
        Thread T = new Thread(new ThreadExample());
        Thread T1 = new Thread(new ThreadExample());
        System.out.println("B");
        T.setName("thread 1");
        T1.setName("thread 2");
        System.out.println("C");
        T.start();
        System.out.println("D");
        T1.start();
    }

    public void run() {
        synchronized (ThreadExample.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Inside run=>"
                            + Thread.currentThread().getName());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}