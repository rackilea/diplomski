public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(0, 0);
        Button button = new Button("test");
        button.setOnAction(ev -> {
            canvas.setWidth(canvas.getWidth() + 10);
            canvas.setHeight(canvas.getHeight() + 10);
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        BorderPane canvasBorderPane = new BorderPane(canvas);
        canvasBorderPane.setPadding(new Insets(10));
        canvasBorderPane.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), Insets.EMPTY)));

        BorderPane root = new BorderPane(canvasBorderPane);
        root.setPadding(new Insets(10));
        root.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), Insets.EMPTY)));
        root.setBottom(button);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}