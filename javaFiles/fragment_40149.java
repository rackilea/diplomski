private EventHandler<ActionEvent> createBtnHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        testLabel.setText(ExtendingViewController.super.getIdField().getText());
    }
};