int numberOfMillisecondsInTheFuture = 10000; // 10 sec
Date timeToRun = new Date(System.currentTimeMillis()+numberOfMillisecondsInTheFuture);
Timer timer = new Timer();

timer.schedule(new TimerTask() {
        public void run() {
            // Task here ...
        }
    }, timeToRun);