Runnable collide = new Runnable() {
        @Override
        public void run() {
            Platform.runLater(() ->
                damageEffect()
            );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() ->
                resetEffect()
            );
        }
    };
    new Thread(collide).start();