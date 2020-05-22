@Override
public void start(Stage primaryStage) throws IOException {
    FXMLLoader outerLoader = new FXMLLoader(getClass().getResource("outer.fxml"));

    Scene scene = new Scene(outerLoader.load());

    URL inner = getClass().getResource("inner1.fxml");
    // URL inner = getClass().getResource("inner2.fxml");

    FXMLLoader innerLoader = new FXMLLoader(inner);

    // get insertion point from outer fxml
    innerLoader.setRoot(outerLoader.getNamespace().get("insertionPoint"));

    innerLoader.load();

    primaryStage.setScene(scene);
    primaryStage.show();
}