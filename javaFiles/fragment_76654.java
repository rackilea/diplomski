public class GameViewController {

    private final MainApp mainApp;

    public GameViewController(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize() {
        mainApp.getGame().  ... //do something else
    }