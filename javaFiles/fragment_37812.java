public class Controller implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TableView<MyModel> table;
    @FXML
    private TableColumn<MyModel, String> first;
    @FXML
    private TableColumn<MyModel, Boolean> second;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ToggleGroup toggleGroup = new ToggleGroup();

        first.setCellValueFactory(data -> data.getValue().nameProperty());
        second.setCellValueFactory(data -> data.getValue().selectedProperty());
        second.setCellFactory(factory -> new RadioButtonTableCell(toggleGroup));

        MyModel john = new MyModel("John");
        MyModel andrew = new MyModel("Andrew");

        table.getItems().addAll(john, andrew);

        label.textProperty().bind(john.selectedProperty().asString()); // easy check if it works for the backing model.
    }

    private class MyModel {

        private StringProperty name;
        private BooleanProperty selected;

        MyModel(String name) {
            this.name = new SimpleStringProperty(name);
            this.selected = new SimpleBooleanProperty(false);
        }

        StringProperty nameProperty() {
            return name;
        }

        BooleanProperty selectedProperty() {
            return selected;
        }
    }

    private class RadioButtonTableCell extends TableCell<MyModel, Boolean> {

        private RadioButton radioButton;

        RadioButtonTableCell(ToggleGroup toggleGroup) {
            this.radioButton = new RadioButton();
            radioButton.setToggleGroup(toggleGroup);
            // Since you don't edit the cell while select a radioButton, this is the simplest way to set the value to
            // the backing model        
            radioButton.selectedProperty().addListener((observable, oldValue, newValue) ->
                    ((MyModel) getTableRow().getItem()).selectedProperty().set(newValue));
        }

        @Override 
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                return;
            }
            setGraphic(radioButton);
        }
    }

}