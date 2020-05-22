package app ;

public class MainController {

    @FXML
    private BorderPane root ;

    @FXML
    private ListView<View> selector ;

    public void initialize() {
        selector.getSelectionModel().selectedItemProperty().addListener((obs, oldView, newView) -> {
            if (newView == null) {
                root.setCenter(null);
            } else {
                // assumes each FXML is in the same package as its controller
                // (which I think is a nice way to organize things)
                FXMLLoader loader = new FXMLLoader(newView.getControllerType().getResource(newView.getResource()));
                try {
                    root.setCenter(loader.load());
                } catch (IOException exc) {
                    // unrecoverable...
                    throw new UncheckedIOException(exc);
                }
            }
        });

        selector.getItems().addAll(
            new View("Fruits", FruitsController.class, "Fruits.fxml"),
            new View("Vegetables", VegetablesController.class, "Vegetables.fxml")
        );
    }
}