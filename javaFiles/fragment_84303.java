public class AfterburnerPresenter {

    @FXML
    private Label label;

    @Inject
    private Model model;

    public void initialize() {
        label.textProperty().bind(model.textProperty());
    }    

}