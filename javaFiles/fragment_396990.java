@Override
public void start(Stage stage) throws IOException {
    TextArea ta = new TextArea();

    Thread thread = new Thread(() -> {
        Random rand = new Random();
        while (true) {
            int i = rand.nextInt(10);
            if (i == 9) {
                CompletableFuture<ButtonType> future = new CompletableFuture<>();

                // ask for user input
                Platform.runLater(() -> {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setContentText("An error occured. Continue?");
                    future.complete(alert.showAndWait().orElse(ButtonType.CANCEL)); // publish result
                });
                try {
                    if (future.get() == ButtonType.CANCEL) { // wait for user input on background thread
                        break;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    break;
                }
            } else {
                Platform.runLater(() ->ta.appendText(Integer.toString(i) + "\n"));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    });
    thread.setDaemon(true);
    thread.start();

    Scene scene = new Scene(new VBox(ta));


    stage.setScene(scene);
    stage.show();
}