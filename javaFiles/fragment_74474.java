ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    int secondsToWait = 5;
    Runnable task = new Runnable() {
        @Override
        public void run() {
            secondsToWait--;
            lblTimer.setText(secondsToWait + "");
            if (secondsToWait == 0) {
                exec.shutdown();
            }
        }
    };

    lblTimer.setText(secondsToWait + "");
    exec.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);