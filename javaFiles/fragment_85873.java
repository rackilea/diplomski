Button playPause = new Button("play");

ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(r -> {
    Thread t = new Thread(r);
    t.setDaemon(true); // don't prevent program from exiting
    return t;
});

playPause.setOnAction(new EventHandler<ActionEvent>() {

    ScheduledFuture<?> future;
    volatile int counter = 0;

    @Override
    public void handle(ActionEvent event) {
        // (un)schedule the task
        if (future == null) {
            future = executor.scheduleAtFixedRate(() -> {
                System.out.println(counter);
                counter++;
            }, 1, 1, TimeUnit.SECONDS);
            playPause.setText("pause");
        } else {
            future.cancel(false);
            future = null;
            playPause.setText("play");
        }
    }

});