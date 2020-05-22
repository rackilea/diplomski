ContextMenu fillerContextMenu = new ContextMenu(new MenuItem("Do in filler"));
Region filler = (Region) tableView.lookup(".filler");
filler.setOnContextMenuRequested(event -> {
    fillerContextMenu.show(filler, event.getScreenX(), event.getScreenY());
    event.consume();
});