public class Client extends Application {

    private double offset_x;
    private double offset_y;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("design.fxml"));

        Scene scene = new Scene(root, (screenSize.getWidth()/2), screenSize.getHeight()/2);
        scene.setOnMousePressed(event -> {
            offset_x = event.getSceneX();
            offset_y = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - offset_x);
            primaryStage.setY(event.getScreenY() - offset_y);
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}