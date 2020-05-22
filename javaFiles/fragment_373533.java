public class Controller {

    @FXML
    public void initialize() {
        autoCompleteTextField.setCompleter(input -> {
            List<String[]> places = googlePlaces.predictPlaces(input);
            // ...
        });
    }
}