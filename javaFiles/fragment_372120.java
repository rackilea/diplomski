Timer timer = new Timer(); 
timer.scheduleAtFixedRate(new TimerTask() {
    public void run() {
        if (!this.ringtone.isPlaying()) {
            this.ringtone.play();
        }
    }
}, 1000, 100);