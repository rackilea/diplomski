Line line = new Line();
line.setStroke(Color.BLACK);

layout.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.UP) {
        line.setStartX(line.getEndX() + 0);
        line.setStartY(line.getEndY() + 15);
    }
});
layout.getChildren().add(line);
layout.requestFocus();