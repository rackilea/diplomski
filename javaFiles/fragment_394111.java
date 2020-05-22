@Override
public void start(Stage primaryStage) {
    SimpleLocalizedStringProperty prop = new SimpleLocalizedStringProperty("Hello World");
    Button btn = new Button();
    btn.textProperty().bind(prop);
    btn.setOnAction((ActionEvent event) -> {
        prop.set("@@font.dlg.title");
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 500, 300);

    primaryStage.setScene(scene);
    primaryStage.show();
}