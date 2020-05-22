public class MainTest extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #ff0000");
        pane.setLayoutX(100);
        pane.setLayoutY(100);
        pane.setPrefSize(300,300);
        pane.setOnMouseEntered(event -> startAnimation());
        pane.setOnMouseExited(event -> stopAnimation());

        Scene scene = new Scene(new Pane(pane), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void stopAnimation() {
        System.out.println("stop");
        // do whatever you need to start your animation
    }

    private void startAnimation() {
        System.out.println("start");
        // do whatever you need to stop your animation
    }
}