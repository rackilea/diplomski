public class DialogController {

    @FXML
    private Hyperlink hyperlink ;

    @FXML
    private void openURL() {
        HostServicesProvider.INSTANCE.getHostServices().showDocument(hyperlink.getText());
    }
}