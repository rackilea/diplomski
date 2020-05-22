public class MainController {

    @FXML private ProgressBar hungerBar;

    public void setModel(Model model){
        hungerBar.progressProperty().bind(model.hungerProperty().divide(100d));
    }
}