public class NewDateController {

    private ObservableList<String> data ;

    public void setData(ObservableList<String> data) {
        this.data = data ;
    }

    // other code as before...

    // button handler:
    @FXML
    private void handleButtonPress() {
        data.addItem("test");
    }

}