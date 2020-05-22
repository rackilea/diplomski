public class MainController {

    private final HostServices hostServices ;

    public MainController(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @FXML
    private void showDialog() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dialog.fxml"));
        loader.setControllerFactory(new HostServicesControllerFactory(hostServices));
        Parent dialogRoot = loader.load();
        Stage dialog = new Stage();
        dialog.setScene(new Scene(dialogRoot));
        dialog.show();
    }    
}