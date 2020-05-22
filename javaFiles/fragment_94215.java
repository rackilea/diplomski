Task<Void> longRunningTask = new Task<Void>() {

        @Override
        protected Void call() throws Exception {
            dbConnect();
            Platform.runLater(() -> status.setText("Connected"));
            return null;
        }
    };


    button.setOnAction(e -> {
        new Thread(longRunningTask).start();
    });