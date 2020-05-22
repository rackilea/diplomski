Timer timer = new Timer();

    int secondsToWait = 5;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsToWait--;
            lblTimer.setText(secondsToWait + "");
            if (secondsToWait == 0) {
                timer.cancel();
                timer.purge();
            }
        }
    };

    lblTimer.setText(secondsToWait + "");
    timer.scheduleAtFixedRate(task, 1000, 1000);