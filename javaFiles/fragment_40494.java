public class Controller {

    @FXML private ListView<YourType> list;
    @FXML private Button button;

    @FXML
    private void initialize() {
        button.disableProperty()
                .bind(list.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }

}