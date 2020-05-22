public class ConfirmationController implements Initializable {

    ...
    @FXML
    private Label proceed;
    ...
    public void setTextToLabel (String text) {
         proceed.setText(text);
    }
    ...
}