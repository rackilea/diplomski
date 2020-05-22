new Timer().schedule(new TimerTask() {          
    @Override
    public void run() {
        // this code will be executed after time difference between current and user picked time.        
    }
}, getTimeDelay(userPickedTime));