final HBox images = new HBox(10);
...
imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
  @Override public void handle(MouseEvent mouseEvent) {
    final Object selectedNode = mouseEvent.getSource();
    final int    selectedIdx  = images.getChildren().indexOf(selectedNode);

    label.setText(
      "Selected Vehicle: " + (selectedIdx + 1)
    );
  }
});