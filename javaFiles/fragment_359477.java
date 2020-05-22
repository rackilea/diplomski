long delay = 300000L;
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        //do something
    }
}, delay);