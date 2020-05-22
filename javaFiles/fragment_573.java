@Override
public void start(Stage primaryStage) {
    StackPane root = new StackPane();

    root.setOnMouseMoved(new EventHandler<MouseEvent>() {

        long lastTriggered = System.currentTimeMillis();

        @Override
        public void handle(MouseEvent event) {
            long t = System.currentTimeMillis();
            System.out.println("last moved " + (t - lastTriggered) + "ms ago");
            lastTriggered = t;
        }
    });

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}