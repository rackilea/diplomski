grandParent.addControlListener(new ControlListener() { 
    ScheduledExecutorService scheduledExecutorService =
        Executors.newScheduledThreadPool(1);
    ScheduledFuture scheduledFuture;
    @Override
    public void controlResized(ControlEvent e){
        if(scheduledFuture != null) {
            scheduledFuture.cancel();
        }
        scheduledFuture = scheduledExecutorService.schedule(new Callable() {
            public Object call() throws Exception {
                xyz();
                return null;
            }
            }, 1, TimeUnit.SECONDS);
    }

    @Override
    public void controlMoved(ControlEvent e)
    {}
});