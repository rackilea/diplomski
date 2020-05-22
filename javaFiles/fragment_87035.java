final Timer timer = new Timer();
final TimerTask task = new TimerTask() {        
    @Override
    public void run() {
        newMessages();
    }
};      
timer.scheduleAtFixedRate(task, new Date(), 20000);