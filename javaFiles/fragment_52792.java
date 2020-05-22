class PrintDemo {
    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                synchronized (this) {
                    this.notify();
                }
                System.out.println(Thread.currentThread().getName()+" Counter   ---   " + i);
                synchronized (this) {
                    this.wait();
                }
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo PD;

    ThreadDemo(String name, PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized (PD) {
            PD.printCount();
        }
        System.out.println("Thread " + threadName + " exiting.");

        synchronized (PD) {
            PD.notify(); // notify the last waited thread.
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}