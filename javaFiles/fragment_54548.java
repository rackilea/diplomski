public void handle(ActionEvent event) {
    if (event.getSource() == upButton) {
        //this should all be put into a 'slideNode' method
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(500), theElevator);
        translateTransition1.setByX(0);
        translateTransition1.setByY(-50);
        translateTransition1.setCycleCount(1);
        translateTransition1.setAutoReverse(false);
        translateTransition.statusProperty().addListener((obs, oldStatus, newStatus) -> 
            button.setDisable(newStatus==Animation.Status.RUNNING));
        translateTransition1.play();
    }
}