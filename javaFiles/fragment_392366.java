@Override
public void start(Stage stage) {
    FlowPane root = new FlowPane();

    // Results in error
    // Button b1 = new Button("Button");
    // root.getChildren().addAll(b1,b1);

    for (int i = 0; i < 4; i++) {
        Button b = new Button("Button");
        root.getChildren().add(b);
    }

    Scene scene = new Scene(root, 50, 100);

    stage.setScene(scene);
    stage.show();
}