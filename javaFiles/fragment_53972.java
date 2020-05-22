minBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent arg0) {
        ((Stage) ((Node) arg0.getSource()).getScene().getWindow()).setIconified(true);
        // OR
        ((Stage) minBtn.getScene().getWindow()).setIconified(true);
    }
});