class ThreadTask implements Runnable {
    private static AtomicInteger counter = new AtomicInteger();
    private int id;

    public ThreadTask(int id) { this.id = id; }

    public void run() {
        int local = 0;
        while((local = counter.incrementAndGet()) < 500) {
            System.out.println("T" + id + " " + local);
        }
    }
}

...

new Thread(new ThreadTask(0)).start();
new Thread(new ThreadTask(1)).start();