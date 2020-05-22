public class ImageViewSpotDemo extends Application {    
    @Override
    public void start(Stage primaryStage) {     
        Pane root = new Pane();

        ImageView image = new ImageView(new Image("file:src/path/image.png"));
        image.setOnMouseClicked(e -> {

            //A new spot
            Circle spot = new Circle(4);
            spot.setFill(Color.WHITE);
            spot.setCenterX(4.0f);
            spot.setCenterY(4.0f);

            double x = e.getSceneX() - 3;
            double y = e.getSceneY() - 3;

            spot.setLayoutX(x);
            spot.setLayoutY(y);

            root.getChildren().add(spot);
        });

        root.getChildren().add(image);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}