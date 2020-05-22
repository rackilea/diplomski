public class MainController {

    private Stage mainStage;
    private Scene playScene;

    public MainController(Stage pMainStage) {
        mainStage = pMainStage;
    }

    @FXML
    public void initialize() {

        FXMLLoader playSceneLoader = new FXMLLoader(getClass().getResource("PlayScene.fxml"));

        try {
            Parent playSceneLayout = playSceneLoader.load();
            playScene = new Scene(playSceneLayout, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
            playScene.setFill(Color.TRANSPARENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void startLabelClicked() {
        mainStage.setScene(playScene);
        // This line will help you to extend your stage, which contains your scene.
        mainStage.setMaximized(true);
    }

    @FXML
    private void closeRoot() {
        System.out.println("Closing.");
        Platform.exit();
    }
}