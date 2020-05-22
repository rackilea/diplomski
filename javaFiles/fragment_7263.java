public void theTimer() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (totalTime != 59) {
                        totalTime++;
                        timePrint();
                    } else {
                        totalTime = 0;
                        minutes++;
                        timePrint();
                    }
                    checkTime();
                });
            }
        }, 0, 1000);
    }