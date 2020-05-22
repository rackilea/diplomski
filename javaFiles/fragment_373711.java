public void addToNewPlaylist(){

    Tab nTab = new Tab();

    FXMLLoader nLoader = new FXMLLoader(getClass().getResource("/fxml/fxPlaylist.fxml"));
    try {
        Parent nRoot = nLoader.load();
        PlaylistController controller = nLoader.getController();
        controller.setTracks(table.getSelectionModel().getSelectedItems());
        nTab.setContent(nRoot);     
    } catch (IOException e) {
        e.printStackTrace();
    }
    tabPane.getTabs().add(nTab);
}