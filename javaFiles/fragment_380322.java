textArea.setOnDragDetected((MouseEvent event) -> {
    //We want the textArea to be dragged. Could also be copied.
    Dragboard db = textArea.startDragAndDrop(TransferMode.MOVE);

    // Put a string on a dragboard as an identifier
    ClipboardContent content = new ClipboardContent();
    content.putString(textArea.getId());
    db.setContent(content);

    //Consume the event
    event.consume();
});