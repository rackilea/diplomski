private final EventHandler<MouseEvent> mouseEventHandler2 = (MouseEvent me) -> {
    Path path1 = (Path)me.getSource();
    if (me.getEventType() == MouseEvent.MOUSE_ENTERED) {
        path1.setEffect(new DropShadow(20, Color.BLACK));
    }
    if (me.getEventType() == MouseEvent.MOUSE_EXITED) {
        path1.setEffect(null);
    }
        if (me.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            path1.relocate(me.getX(), me.getY());
        }
};

private final EventHandler<MouseEvent> mouseEventHandler = (MouseEvent e) -> {
    if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
        path = new Path();
        path.setStroke(Color.BLACK);
        path.setStrokeWidth(10);
        path.getElements().add(new MoveTo(e.getX(), e.getY()));
        root.getChildren().add(path);
    }
    if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
        path.getElements().add(new LineTo(e.getX(), e.getY()));
    }
    if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
        path.getElements().add(new LineTo(e.getX(), e.getY()));
        path.setOnMouseEntered(mouseEventHandler2);
        path.setOnMouseExited(mouseEventHandler2);
//        path.setOnMouseDragged(mouseEventHandler2);
    }
};