ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

exec.scheduleAtFixedRate(new Runnable(){
    private int time = 0;

    @Override
    public void run(){
        time++;
        System.out.println("Time: " + time);
    }
}, 0, 500, TimeUnit.MILLISECONDS);