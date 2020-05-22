timer = new Timer();    
refresher = new TimerTask() {
    public void run() {
        ActivityMain.this.sendEmptyMessage(REFRESH);
    };
};
// first event immediately,  following after 1 seconds each
timer.scheduleAtFixedRate(refresher, 0, 1000);