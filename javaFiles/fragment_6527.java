import java.util.*;

public class ObservableExample {

    public static void main(String[] args) throws Exception {
        CountTracker t = new CountTracker();
        t.addObserver(new Observer() {
            public void update(Observable observable, Object arg) {
                System.out.println("observed " + arg);
            }
        });
        t.startNotifying();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100L);
            t.incrementCount();
        }         
        t.quitNotifying();       
        System.out.println("done");         
    }
}

class CountTracker extends Observable {    
    private int count = 0;
    private Thread notificationThread;

    public synchronized void incrementCount() {
        count++;
        setChanged();
    }

    public synchronized void startNotifying() {
        if (notificationThread == null || !notificationThread.isAlive()) {
            notificationThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            Thread.sleep(1000L);
                            String event = "current value of count is " 
                            + CountTracker.this.count;
                            CountTracker.this.notifyObservers(event);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            notificationThread.start();
        }
    }

    public synchronized void quitNotifying() throws InterruptedException {
        if (notificationThread == null || !notificationThread.isAlive()) {
            return;
        }
        notificationThread.interrupt();
        System.out.println("wait for notification thread to terminate");
        notificationThread.join();
    } 
}