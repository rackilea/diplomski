playListSelectionModel.addSelectionChangerHandler(new SelectionChangeEvent.Handler(SelectionChangeEvent event) {
    ArrayList<PlayList> playLists; // all playlists
    for (PlayList playlist:playlists) {
        boolean isSelected = playlistSelectionModel.isSelected(playlist);
        for (String song : selectedPlaylist.getSongs()) {
           selectionModel.setSelected(song, isSelected);
        } 
    }
}};