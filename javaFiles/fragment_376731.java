import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EntranceBarrier extends Thread {

    private volatile boolean open = false;
    private volatile boolean requestedState = false;

    private Lock lock = new ReentrantLock();

    public void OpenBarrier() {
        try {
            lock.lock();
            printState();
            lock.unlock();

            while (true) {
                lock.lock();
                if (requestedState != open) {
                    printState();

                    Thread.sleep(5000);
                    open = requestedState;

                    printState();
                }
                lock.unlock();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            lock.unlock();
        }
    }

    private void printState() {
        if (requestedState == open) {
            if (open)
                System.out.println("Entrance Barrier " + getName() + " Opened");
            else
                System.out.println("Entrance Barrier " + getName() + " Closed");
        } else {
            if (requestedState)
                System.out.println("Entrance Barrier " + getName() + " Opening");
            else
                System.out.println("Entrance Barrier " + getName() + " Closing");
        }
    }

    public void run() {
        OpenBarrier();
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        if (lock.tryLock()) {
            this.requestedState = open;
            lock.unlock();
        } else {
            System.out.println("Entrance Barrier " + getName() + " is moving");
        }
    }
}