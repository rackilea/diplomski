public class CSSParsingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ColorPicker cpBackground = new ColorPicker();
        ColorPicker cpBase = new ColorPicker();
        ColorPicker cpDefaultButton = new ColorPicker();  

        VBox root = new VBox(10, cpBackground, cpDefaultButton, cpBase);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        cpBackground.setValue(parseColor("-fx-background"));
        cpDefaultButton.setValue(parseColor("-fx-default-button"));
        cpBase.setValue(parseColor("-fx-base"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color parseColor(String property) {
        CSSParser parser = new CSSParser();
        try {
            Stylesheet css = parser.parse(getClass().getResource("style.css").toURI().toURL());
            final Rule rootRule = css.getRules().get(0); // .root
            return (Color) rootRule.getDeclarations().stream()
                .filter(d -> d.getProperty().equals(property))
                .findFirst()
                .map(d -> ColorConverter.getInstance().convert(d.getParsedValue(), null))
                .get();
        } catch (URISyntaxException | IOException ex) { }
        return Color.WHITE;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}