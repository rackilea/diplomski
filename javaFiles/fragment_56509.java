public class CSSParsingApp extends Application {

    private CssToColorHelper helper = new CssToColorHelper();

    @Override
    public void start(Stage primaryStage) {
        ColorPicker cpBackground = new ColorPicker();
        ColorPicker cpBase = new ColorPicker();
        ColorPicker cpDefaultButton = new ColorPicker();  

        VBox root = new VBox(10, cpBackground, cpDefaultButton, cpBase, helper);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        cpBackground.setValue(getNamedColor("-fx-background"));
        cpDefaultButton.setValue(getNamedColor("-fx-default-button"));
        cpBase.setValue(getNamedColor("-fx-base"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color getNamedColor(String name) {
        helper.setStyle("-named-color: " + name + ";");
        helper.applyCss();

        return helper.getNamedColor();      
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}