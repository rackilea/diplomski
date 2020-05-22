source.setOnMousePressed(me -> {
    me.consume();

    drawLine(source, me);
    me.setDragDetect(true); // trigger dragDetected event immediately
});
source.setOnDragDetected(evt -> {
    source.startFullDrag();
    removeLine = true;
});

...

source.setOnMouseReleased(event -> {
    if (removeLine) {
        group.getChildren().remove(line);
    }
});