public void start(Stage primaryStage) {
    Label label = new Label();
    label.setText("Hello");
    label.setFont(Font.font("Arial", 32));

    System.out.println(label.getWidth());

    StackPane root = new StackPane();
    root.getChildren().add(label);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();

    System.out.println("------");
    System.out.println(label.getWidth());
}