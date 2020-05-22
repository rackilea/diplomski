@Override
public void initialize(URL location, ResourceBundle resources) {

    PauseTransition delay = new PauseTransition(Duration.seconds(1));
    delay.setOnFinished(event -> {
        //load your view
    });
    delay.play();

}