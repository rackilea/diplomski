private Thread thread;
private Thread managerThread;
private final Object lock = new Object();

Scanner in;

public Storyline() {
    setUpThread();
}

private void setUpThread() {
    managerThread = new Thread(() -> {
        while(true) {
            in = new Scanner(System.in);
            in.nextLine();
            resumeThread(); 
        }
    });
    thread = new Thread(() -> {
        synchronized (lock) {
            while(true){
                System.out.print("A");
                try {
                    lock.wait();
                } catch (InterruptedException e) {}
                System.out.print("B");
                try {
                    lock.wait();
                } catch (InterruptedException e) {}
            }
        }
    });
    managerThread.start();
    thread.start();
}


public void resumeThread() {
    synchronized(lock){
        lock.notify();
    }
}