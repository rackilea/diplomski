ExecutorService ex = Executors.newSingleThreadExecutor();
    Future<?> future = ex.submit(new Runnable() {
        public void run() {
            try {
                //Do some long running operations
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed operation");
        }
    });
    Object someObject = future.get(10, TimeUnit.SECONDS);