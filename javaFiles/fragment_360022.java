scene.addEventFilter(ScrollEvent.SCROLL, e -> {
    if (hoverNode.get() != null) {
        Event.fireEvent(hoverNode.get(), e);
    }
});
scene.addEventHandler(ScrollEvent.SCROLL, e -> {
    if (hoverNode.get() != null) {
        Event.fireEvent(hoverNode.get(), e);
    }
});