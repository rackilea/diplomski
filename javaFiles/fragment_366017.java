@Override
public void start(Stage primaryStage) {
    RotatorControl rotator = new RotatorControl("Rotate");

    Scene scene = new Scene(rotator, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}