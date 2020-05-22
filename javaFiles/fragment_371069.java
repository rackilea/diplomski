public class MyApplication extends Application {

    private IntegerProperty value = new SimpleIntegerProperty(0);

    @Override
    public void start(Stage primaryStage) {
        try {
            HBox root = new HBox();
            Scene scene = new Scene(root, 400, 400);
            Label label = new Label();
            Button button = new Button("Press Me");

            button.setOnAction(event -> {
                // Background Task
                Task<Void> task = new Task<Void>() {
                    @Override
                    protected Void call() {

                        for (int i = 0; i < 1001; i++) {
                            int intVal = i;
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException ignored) {
                            }
                            // Update the GUI on the JavaFX Application Thread
                            Platform.runLater(() -> value.setValue(intVal));

                        }
                        return null;
                    }
                };

                Thread th = new Thread(task);
                th.setDaemon(true);
                th.start();
            });

            label.textProperty().bind(value.asString());
            root.getChildren().addAll(button, label);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}