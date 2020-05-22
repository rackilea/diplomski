public class Test extends Application {
    private Circle circle;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) throws Exception {

        /**
         * MShape
         */
        circle = new Circle(20);
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setFill(Color.RED);


        transition = new TranslateTransition();
        transition.setToX(500);
        transition.setToX(500);

        transition.setDuration(Duration.seconds(5));
        transition.setNode(this.circle);

//      this.getChildren().add(circle);

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent paramT) {
                transition.play();
                System.out.println("hello  " + circle.getCenterX() + "  " + circle.getCenterY());

            }
        });

        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);

        root.getChildren().add(circle);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}