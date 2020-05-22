public void start(Stage primaryStage) {
    HBox hbox = new HBox(10);
    TextField field = new TextField();
    HBox.setHgrow(field, Priority.ALWAYS);
    hbox.setAlignment(Pos.BASELINE_LEFT);
    hbox.getChildren().addAll(
        new Label("Search:"), field, new Button("Go")
    );
    hbox.setPadding(new Insets(10));

    Scene scene = new Scene(hbox, 600, 250, Color.WHITE);
    primaryStage.setScene(scene);
    primaryStage.show();
}