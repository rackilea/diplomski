@FXML
ObservableList<GridPane> mesas;

@Override
public void initialize(URL location, ResourceBundle resources) {
    mesas = FXCollections.observableArrayList(fila1,fila2,fila3,fila4,fila5);
}