public SongCell(ListView<Song> list, Playlist playlist) {

    // ...

    setOnMousePressed(event -> {

        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
            playlist.setIndex(this.getIndex());
            playlist.play();

        }

        event.consume();
    });

}

@Override
public void updateItem(Song item, boolean empty) {
    super.updateItem(item, empty);

    if (!empty && item != null) {
        this.setText(item.toString());
        this.setContextMenu(listContextMenu);
    } else {
        this.setText("");
        this.setContextMenu(null);
    }
}