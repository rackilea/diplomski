Timer timer;

private void startBroadcastLoop() {
    timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
            // Send broadcast
            Intent broadcastIntent = new Intent ("send broadcast");
            sendBroadcast(broadcastIntent);
        }

    },0,1000); // Send broadcast every second
}

private void stopBroadcastLoop() {
    if(timer!=null){
        timer.cancel();
        timer = null;
    }    
}