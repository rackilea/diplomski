class ComboController {
    @FXML private static ComboBox<Tile> comboBoxTileList;

    public void refreshTileList(Tile tile) {
        comboBoxTileList.getItems().add(tile);
    }
}

class AnotherController {
    @FXML private Button createTile;
    @FXML private Button newCombo;
    @FXML private StackPane mainPane;

    private comboController;

    @FXML private void createTile(ActionEvent event) {
        if (comboController == null) {
            return;
        }

        comboController.refreshTileList(
            new Tile()
        );
    }

    @FXML private void newCombo(ActionEvent event) {
        try {
            comboController = new ComboController();

            FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                    "combo.fxml"
                )
            );
            loader.setController(comboController);

            Pane comboPane = (Pane) loader.load();

            mainPane.getChildren().setAll(comboPane);
        } catch (IOException e) {
            // handle exception. 
        }
    }
}