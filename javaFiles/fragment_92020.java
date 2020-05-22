public class DialogController {

    @FXML
    private Hyperlink hyperlink ;

    private final HostServices hostServices ;

    public DialogController(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @FXML
    private void openURL() {
        hostServices.openDocument(hyperlink.getText());
    }
}