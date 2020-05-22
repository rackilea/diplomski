public class GameController implements Initializable {
    private BooleanProperty gameRunning = new SimpleBooleanProperty(false);

    @FXML Button continueBtn;

    @FXML protected void handleNew(ActionEvent event) {
        gameRunning.set(true);
    }
    @FXML protected void handleLoad(ActionEvent event) {

    }
    @FXML protected void handleSave(ActionEvent event) {

    }
    @FXML protected void handleQuit(ActionEvent event) {
        gameRunning.set(false);
    }
    @FXML protected void handleContinue(ActionEvent event) {
        System.out.println("Continue!");
        //parent.handle(new GUIEvent(GUIEvent.Type.CONTINUE));
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        continueBtn.visibleProperty().bind(gameRunning);  
    }
}