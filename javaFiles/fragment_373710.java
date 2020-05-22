public class PlaylistController {

    @FXML
    private TableView<Track> nTable ;

    // ...

    public void setTracks(List<Track> tracks) {
        nTable.getItems().setAll(tracks);
    }

    // ...
}