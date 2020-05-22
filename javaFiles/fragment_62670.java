final ObjectProperty<PlaylistTable> currentSong = new SimpleObjectProperty();
final PseudoClass playing = PseudoClass.getPseudoClass("playing");

playlistTable.setRowFactory(e -> {

    final TableRow<PlaylistTable> row = new TableRow<>();
    InvalidationListener listener = o -> {
        row.pseudoClassStateChanged(playing, currentSong.get() == row.getItem());
    };
    row.itemProperty().addListener(listener);
    currentSong.addListener(listener);

    ...

    return row;
});