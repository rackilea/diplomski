public class Controller {
    @FXML
    private LabelFlow labelFlow ;

    public void initialize() {
        for (Label label : labelFlow.getLabels()) {
            // do whatever you need with label....
        }
    }
}