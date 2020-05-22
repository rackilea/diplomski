public class Controller { /* or whatever name you have, again, you can't be bothered to post a MCVE */

    @FXML
    private BorderPane root ;

    @FXML
    private void buttonHandler() throws IOException {
        Pane sub = (Pane) FXMLLoader.load(getClass().getResource("../ready.fxml"));
        root.setCenter(sub);
    }

    // ...
}