public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox(5);
        root.setPadding(new Insets(10));

        Label label = new Label("This is some long text that should be wrapped.");
        label.setWrapText(true);
        label.setPrefWidth(100);

        root.getChildren().add(label);

        primaryStage.setWidth(200);
        primaryStage.setHeight(200);

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }
}