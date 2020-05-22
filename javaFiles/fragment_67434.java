anchor.setOnMouseClicked(event -> {
    Circle circle = new Circle();
    border.getChildren().add(circle);
    circle.setCenterX(event.getX());
    circle.setCenterY(event.getY());
    circle.setRadius(radius);
    circle.setOnMouseClicked(e -> {
        circle.setRadius(circle.getRadius() * 1.5);
        // prevent event from propagating to pane:
        e.consume();
    });
});