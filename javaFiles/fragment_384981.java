Object monitor = new Object();
volatile boolean done = false, wait = false;

/* Running on one thread: */
public void run() {
    synchronized(monitor) {
        while(!done) {
            while(wait) {
                monitor.wait();
            }
            gameLogicAndStuff();
        }
    }
}

/* Running on another thread: */
public void showResetForm() {
    wait = true;
    synchronized(monitor) {
        actuallyShowResetForm();
        wait = false;
        monitor.notifyAll();
    }
}