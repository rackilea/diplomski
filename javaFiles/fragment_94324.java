import java.util.concurrent.TimeUnit;

public class StartPauseDemo extends Thread {
    volatile int i = 1;

    public void pause() {
        i = 0;
    }

    public synchronized void unPause() {
        i = 1;
        notify();// wake up thread
    }

    @Override
    public void run() {
        while (i==1) {
            // logic of method for example printing time every 200 miliseconds
            System.out.println(System.currentTimeMillis());
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i==0) {
                synchronized (this) {// thread must possess monitor of object on
                                        // which will be called wait() method,
                                        // in our case current thread object
                    try {
                        wait();// wait until someone calls notify() or notifyAll
                                // on this thred object
                                // (in our case it is done in unPause() method)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // test - pausing and unpausing every 1 sec
    public static void main(String[] args) throws InterruptedException {
        StartPauseDemo sp = new StartPauseDemo();
        sp.start();// start thread
        while (true) {
            System.out.println("pausing");
            sp.pause();
            TimeUnit.SECONDS.sleep(1);

            System.out.println("unpausing");
            sp.unPause();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}