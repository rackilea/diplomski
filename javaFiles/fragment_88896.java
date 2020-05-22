Button button = new Button("target name");
button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        handleClick(button.getText());
    }
});