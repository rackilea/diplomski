label.setOnDragOver(new EventHandler <DragEvent>() {

    public void handle(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
        event.consume();
    }
});