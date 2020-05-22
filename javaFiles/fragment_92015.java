public class MainController {

    private HostServices hostServices ;

    public HostServices getHostServices() {
        return hostServices ;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @FXML
    private void showDialog() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dialog.fxml"));
        Parent dialogRoot = loader.load();
        DialogController dialogController = loader.getController();
        dialogController.setHostServices(hostServices);
        Stage dialog = new Stage();
        dialog.setScene(new Scene(dialogRoot));
        dialog.show();
    }
}