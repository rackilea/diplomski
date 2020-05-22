public class FooController {
    @FXML
    MenuButton menuButton;

    public void initialize() {
        menuButton.getItems().addAll(
            FXCollections.observableArrayList(
                new CheckMenuItem("T1"),
                new CheckMenuItem("T1C"),
                new CheckMenuItem("T2")
            )
        );
    }
}