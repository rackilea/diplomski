public class Test extends Application {

    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 300;

    @Override
    public void start(Stage primaryStage) {
        TextArea text = new TextArea();
        BorderPane content = new BorderPane(text);
        Scene scene = new Scene(content, PREF_WIDTH, PREF_HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}