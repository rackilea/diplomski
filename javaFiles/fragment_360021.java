scene.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, e -> {
    hoverNode.set(null);
});
scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
    hoverNode.set(e.getTarget());
});