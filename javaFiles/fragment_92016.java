public class DialogController {

    @FXML
    private Hyperlink hyperlink ;

    private HostServices hostServices ;

    public HostServices getHostServices() {
        return hostServices ;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @FXML
    private void openURL() {
        hostServices.openDocument(hyperlink.getText());
    }
}