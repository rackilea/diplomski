ExecutorService exec = Executors.newFixedThreadPool(10);
for(int i = 0; i < 10; i++) {
    exec.submit(new Runnable() {
                    public void run() {
                        ThreadIceCream tic = new ThreadIceCream();
                    }
                });        
}

exec.shutdown();
exec.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);