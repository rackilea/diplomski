public class FXMLController implements Initializable {

    @FXML
    protected void handleTextFieldAction(ActionEvent e) {
        endEdit(false);
    }

    private void endEdit(boolean flag) {
        System.out.println("Flag value: " + flag);
        // Your implementation here
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}