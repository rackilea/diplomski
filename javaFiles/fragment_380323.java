flowPane2.addEventHandler(DragEvent.DRAG_OVER, (DragEvent event) -> {
    if (event.getGestureSource() != flowPane2
            && event.getDragboard().hasString()) {
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    }
    event.consume();
});