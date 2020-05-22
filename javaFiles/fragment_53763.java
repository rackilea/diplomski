ses.scheduleWithFixedDelay(new Runnable() {
        @Override
        public void run() {
            runtime += 1000;
            Platform.runLater(() -> updateData());
        }
    }, 0, 500, TimeUnit.MILLISECONDS);