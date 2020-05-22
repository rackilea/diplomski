public class ChannelControls extends HBox {

    @FXML
    private ComboBox<String> channel ;
    @FXML
    private TextField delay ;
    @FXML
    private Button start ;

    public ChannelControls() {
        try {
            FXMLLoader loader = new FXMLLoader("ChannelControls.fxml");
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException exc) {
            // this is pretty much fatal:
            throw new UncheckedIOException(exc);
        }
    }

    @FXML
    private void startRecording(ActionEvent event) {
        String channelName = channel.getValue();
        long delayTime = Long.parseLong(delay.getText());
        // ...
    }

    // other methods as needed
}