square.setOnMouseMoved(new EventHandler<MouseEvent>() {

  @Override
  public void handle(final MouseEvent event) {

      System.out.println(event.getScreenX());
      System.out.println(event.getScreenY());
    }
});
square.setOnMouseEntered(new EventHandler<MouseEvent>() {

  @Override
  public void handle(final MouseEvent event) {
    square.setFill(Color.GREEN);
  }
});
square.setOnMouseExited(new EventHandler<MouseEvent>() {

  @Override
  public void handle(final MouseEvent event) {
    square.setFill(null);

  }
});