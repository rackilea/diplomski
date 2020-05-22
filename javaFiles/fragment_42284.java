public class MainMenuController {

    @FXML
    private Button onlineGame ;

    @FXML
    private void onlineGame(ActionEvent event) {
        // button can't be pressed until it is in a scene, so getScene()
        // here cannot return null:
        addHandlers(game.getScene());
        prepareGame();
        startGame();
    }

    // ...
}