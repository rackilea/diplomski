@FXML
private Image redSeat;
@FXML
private Image greenSeat;

@FXML
private void onClick(MouseEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to proceed with the (un)booking?", ButtonType.YES, ButtonType.NO);
    if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
        ImageView imageView = (ImageView) event.getSource();
        imageView.setImage(imageView.getImage() == redSeat ? greenSeat : redSeat);
    }
}