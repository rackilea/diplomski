private ObservableList<MusicItem> addTableItems() throws UnknownHostException {
    ObservableList<MusicItem> musicItem = FXCollections.observableArrayList();
    Database database = new Database();
    for (MusicItem item: database.datastore.find(MusicItem.class).asList()){
        musicItem.addAll(item);
    }
    return musicItem;
}