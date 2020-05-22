class AThread implements Runnable {
    Thread t;
    Thread threadToWaitFor;

    AThread(Thread threadToWaitFor) {
        t = new Thread(this);
        this.threadToWaitFor = threadToWaitFor;
    }

    public void run() {
        // First wait for the other thread to finish
        threadToWaitFor.join();

        // ...
    }

    // ...
}

public class WaitForThread {
    public static void main(String[] args) {
       BThread t2 = new BThread();
       AThread t1 = new AThread(t2.t);

        t2.t.start();
        t1.t.start();
    }
}