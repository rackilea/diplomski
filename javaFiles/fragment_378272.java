Timer timer = new Timer("Display Timer");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timerActions();
            }
        };
        // This will invoke the timer every second
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }