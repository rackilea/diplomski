public class CSSParsingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ColorPicker cpBackground = new ColorPicker(retrieveColor("value1"));
        ColorPicker cpBase = new ColorPicker(retrieveColor("value2"));
        ColorPicker cpDefaultButton = new ColorPicker(retrieveColor("value3"));

        VBox root = new VBox(10, cpBackground, cpDefaultButton, cpBase);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color retrieveColor(String value) {
        Pane pane = new Pane();
        pane.getStyleClass().add(value);

        Scene sceneAux = new Scene(pane);
        sceneAux.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        pane.applyCss();
        return (Color) pane.getBackground().getFills().get(0).getFill();
    }

    public static void main(String[] args) {
        launch(args);
    }

}