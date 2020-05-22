setOnMouseDragged(event -> {
    setManaged(false);
    this.setTranslateX(event.getX() + this.getTranslateX() - 120);
    this.setTranslateY(event.getY() + this.getTranslateY() - 50);
    event.consume();
});