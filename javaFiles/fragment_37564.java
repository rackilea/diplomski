@Override
protected void doStart() {
    executorService = Executors.newFixedThreadPool(2);
    Lock lock = new ReentrantLock();   // create a share lock to lock in multi threads
    if (running.compareAndSet(false, true)) {
        for (int x = 0; x < 10; x++) {
            executorService.submit(new Producer(Integer.toString(x), lock)); //pass this lock to every producer
        }
    }
}
protected class Producer implements Runnable {
    String prefix;
    final Lock lock;

    public Producer(String prefix, Lock lock) {
        this.prefix = prefix;
        this.lock = lock;
    }

    private void send() {
        lock.lock();
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }finally{
            lock.unlock();
        }
    }

    public void run() {
        send();
    }
}