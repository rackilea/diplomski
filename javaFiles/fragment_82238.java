public class GUIController implements Initializable {
    @FXML 
    private GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridPane.add(new Label(MonopolyConstants.FIELD_NAMES[0]), 0, 0);
        gridPane.add(new Label(MonopolyConstants.FIELD_NAMES[1]), 1, 0);
        gridPane.add(new Label(MonopolyConstants.FIELD_NAMES[2]), 2, 0);
        ...
        gridPane.add(new Label(MonopolyConstants.FIELD_NAMES[39]), 11, 11);
    }
}