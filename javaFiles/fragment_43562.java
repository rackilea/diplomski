@Override
public void initialize(URL location, ResourceBundle resources) {
    playView.setImage(new Image(getClass().getResource("Pause.png").toExternalForm()));
    playView.setVisible(false);
    playView.setOnMouseClicked(event -> onPlayView());
    Platform.runLater(this::onStartup);
}