@FXML
  ImageView imageId;

  @FXML
  private void handleButtonAction(ActionEvent event) throws IOException {
      Image img = new Image("../img/img.jpg");
      imageId.setImage(img);
  }