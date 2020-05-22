private static class ThreadDemo1 extends Thread {
    public void run() {
        synchronized (Lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try {
                // modelling a workload here: 
                // can take anywhere up to 10 seconds
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (Lock2) {
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }
}

private static class ThreadDemo2 extends Thread {
    public void run() {
        synchronized (Lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            try {
                // modelling a workload here: 
                // can take anywhere up to 10 seconds
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (Lock1) {
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }
}