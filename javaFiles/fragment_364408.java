public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            Pane pane = new Pane();
            pane.setStyle("-fx-background-color:red;");
            StackPane sp = new StackPane();
            VBox vbox = new VBox();

            HBox hbox = new HBox();
            hbox.setSpacing(30);


            for (int i = 0; i< 5; i++) {
                Button b = new Button("Button");
                b.setOnAction(e -> System.out.println("Button clicked"));
                hbox.getChildren().add(b);
            }

            vbox.getChildren().add(hbox);
            sp.getChildren().addAll(pane, vbox);

            Line line = new Line(10, 10, 500, 10);
            line.setStrokeWidth(3);
            pane.getChildren().add(line);
            line.setOnMouseClicked(e -> {
                System.out.println("Line Clicked!");
            });

            // Set pickOnBounds to vbox and hbox
            vbox.setPickOnBounds(false);
            hbox.setPickOnBounds(false);
            root.setCenter(sp);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}