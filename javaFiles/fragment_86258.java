while (true) {
        long sleepTime = fTimeBasedTriggeringPolicy.getNextRollover()
                - System.currentTimeMillis();
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime + EMPTY_LOG_EVENT_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fTimeBasedTriggeringPolicy.checkRollover(new EmptyLogEvent());
    }