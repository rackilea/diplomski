public class DialogPresenter {

    @Inject
    private HostServices hostServices ;

    @FXML
    private Hyperlink hyperlink ;

    @FXML
    private void showURL() {
        hostServices.showDocument(hyperlink.getText());
    }
}