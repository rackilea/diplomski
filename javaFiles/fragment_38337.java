public class Controller implements Initializable {
    @FXML private CheckListView<String> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        list.getItems().addAll("Apple", "Lemon", "Orange", "Banana");

        list.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SPACE)) {
                revertCheck(list.getSelectionModel().getSelectedIndices());
            }
        });

    }

    private void revertCheck(ObservableList<Integer> selectedIndices) {
        selectedIndices.forEach(index -> {
            // If needed to skip the selected index which is handled by JavaFx
            if (!index.equals(list.getSelectionModel().getSelectedIndex())) {
                if (list.getCheckModel().isChecked(index)) {
                    list.getCheckModel().clearCheck(index);
                } else {
                    list.getCheckModel().check(index);
                }
            }
        });
    }
}