final Timer imageTimer = new Timer();
imageTimer.schedule( new TimerTask() {
    public void run() {
        changeImage();
    }
}, 0, 10000 ); //<-- every 10 seconds.