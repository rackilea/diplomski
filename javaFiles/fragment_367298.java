import com.airhacks.afterburner.views.FXMLView;

public class NoteListView extends FXMLView {
    //usually nothing to do, FXML and CSS are automatically
    //loaded and instantiated
}

public class AirpadPresenter implements Initializable {    
    @Inject // injected by afterburner, zero configuration required
    NotesStore store;

    @FXML // injected by FXML
    AnchorPane noteList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //view constructed from FXML
        NoteListView noteListView = new NoteListView();

        //fetching and integrating the view from FXML
        Parent view = noteListView.getView();
        this.noteList.getChildren().add(view);
    }
}