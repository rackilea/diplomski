public class RectangleDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Group group = new Group();

        for( int i = 0; i < 5; i++) {

            Rectangle rectangle = new Rectangle( 100.0, i*25.0 + 80.0, 20.0, 20.0);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTGRAY);

            group.getChildren().add( rectangle);

        }

        pane.getChildren().add(group);

        primaryStage.setScene(new Scene( pane, 640, 480));
        primaryStage.show();
    }

}