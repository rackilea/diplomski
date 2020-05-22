ExecutorService es = Executors.newSingleThreadExecutor();
es.submit(new Runnable() {
    public void run() {
        Thread.currentThread().setName("Working on task A");
        try {
            System.out.println("Running: "+Thread.currentThread());
        } finally {
            Thread.currentThread().setName("parked worker thread");
        }
    }
});
es.shutdown();