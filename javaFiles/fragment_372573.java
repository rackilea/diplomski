EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        // CODE
    }
};
button.setOnAction(eh); //registered
button.setOnAction(null); //unregistered
button.setOnAction(eh); //re-registered