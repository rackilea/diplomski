Runnable run = new Runnable() {
    public void run() {
        try {
           // do something which might throw an Exception
        } catch(Exception e) {
           log.error(e);
        }
    }
};
scheduledExecutorService.scheduleAtFixedRate(run, delay, period, unit);