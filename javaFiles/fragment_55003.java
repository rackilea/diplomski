public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);

            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            RadioButton rb = new RadioButton("In all directions);

            ComboBox<PseudoClass> combo = new ComboBox<>();
            combo.getItems().addAll(PseudoClass.getPseudoClass("left"), 
                    PseudoClass.getPseudoClass("top"),
                    PseudoClass.getPseudoClass("right"), 
                    PseudoClass.getPseudoClass("bottom"));

            combo.valueProperty().addListener((obs, oldVal, newVal) -> {

                if (oldVal != null)
                    rb.pseudoClassStateChanged(oldVal, false);

                rb.pseudoClassStateChanged(newVal, true);
            });

            root.setTop(combo);
            root.setCenter(rb);

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