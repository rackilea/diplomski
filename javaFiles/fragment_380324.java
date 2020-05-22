flowPane2.addEventHandler(DragEvent.DRAG_DROPPED, (DragEvent event) -> {
    //Get the dragboard back
    Dragboard db = event.getDragboard();
    boolean success = false;
    //Could have some more thorough checks of course.
    if (db.hasString()) {
        //Get the textarea and place it into flowPane2 instead
        flowPane2.getChildren().add(textArea);
        success = true;
    }
    //Complete and consume the event.
    event.setDropCompleted(success);
    event.consume();
});