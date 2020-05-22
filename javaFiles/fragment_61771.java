listView.setCellFactory(lv -> new ListCell<>() {

  private final Pane imageViewContainer = new Pane();

  @Override
  protected void updateItem(ImageView item, boolean empty) {
    super.updateItem(item, empty);
    if (empty || item == null) {
      imageViewContainer.getChildren().clear();
      setGraphic(null);
    } else {
      imageViewContainer.getChildren().setAll(item);
      setGraphic(imageViewContainer);
    }
  }
});