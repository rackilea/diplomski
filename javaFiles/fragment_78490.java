@Override
public void start(Stage primaryStage) throws Exception {
    Parent parent = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    Scene scene = new Scene(parent, screenBounds.getWidth(), 
    screenBounds.getHeight());
    primaryStage.setFullScreen(true);

    primaryStage.setScene(scene);
    primaryStage.setFullScreenExitHint("hello");
    primaryStage.show();
}