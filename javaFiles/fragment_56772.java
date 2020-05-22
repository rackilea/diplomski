public class MyApplication extends Application {


    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);

            ScrollablePane pane = new ScrollablePane();
            pane.setOnScrollEnded(e -> System.out.println("Scroll just has been ended"));

            root.setCenter(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}