public class Controller {

    @FXML
    private FlowPane container ;

    private List<Label> labels ;

    public void initialize() {
        labels = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            Label label = new Label("Label "+i);
            labels.add(label);
            container.getChildren().add(label);
        }
    }
}