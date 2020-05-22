public void theTimer() {
    mTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (totalTime != 59) {
                        totalTime++;
                        timePrint();
                    } else {
                        totalTime = 0;
                        minutes++;
                        timePrint();
                    }
                    checkTime();
                }
            });
        }
    }, 0, 1000);
}