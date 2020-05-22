protected static void startTimer() {
    isTimerRunning = true; 
    timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            elapsedTime += 1; //increase every sec
            mHandler.obtainMessage(1).sendToTarget();
        }
    }, 0, 1000);
}

public Handler mHandler = new Handler() {
    public void handleMessage(Message msg) {
        StopWatch.time.setText(formatIntoHHMMSS(elapsedTime)); //this is the textview
    }
};