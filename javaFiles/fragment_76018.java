Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            //some execution
        }
    };
    timer.schedule(timerTask, 5000, 5000);