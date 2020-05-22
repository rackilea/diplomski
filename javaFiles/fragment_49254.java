@FXML
void blockChange(MouseEvent event) {
    Object source = event.getSource();
    if (source instanceof Label) {
        ((Label) source).setText("new Text");
    }
}