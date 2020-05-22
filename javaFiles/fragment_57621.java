final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

exec.schedule(new Runnable(){
    @Override
    public void run(){
        MyMethod();
    }
}, 1, TimeUnit.SECONDS);