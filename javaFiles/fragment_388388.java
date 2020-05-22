@Override
public void start(Stage primaryStage) {
    Scene scene = new Scene(new StackPane(new Label("Antialising\nBalanced")), 
            300, 300, true, SceneAntialiasing.BALANCED);
    primaryStage.setScene(scene);
    primaryStage.show();
}