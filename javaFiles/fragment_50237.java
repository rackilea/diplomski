private void displayLabelForData(XYChart.Data<String, Number> data) {
  final Node node = data.getNode();
  final Text dataText = new Text(data.getYValue() + "");
  node.parentProperty().addListener(new ChangeListener<Parent>() {
    @Override public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
      Group parentGroup = (Group) parent;
      parentGroup.getChildren().add(dataText);
    }
  });

  node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
    @Override public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
      dataText.setLayoutX(
        Math.round(
          bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
        )
      );
      dataText.setLayoutY(
        Math.round(
          bounds.getMinY() - dataText.prefHeight(-1) * 0.5
        )
      );
    }
  });
}