public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui.fxml"));

    Scene scene = new Scene(root);

    stage.setTitle("My app");
    stage.setScene(scene);

    stage.show();

    stage.setMinHeight(stage.getHeight());
    stage.setMinWidth(stage.getWidth());
}