submitButton.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
        submitData();
    }
});

scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent ke) {
        switch (ke.getCode()) {
            case ENTER:
                submitData();
                break;
            default:
                break;
        }
 }});