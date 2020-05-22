public class ChannelController {

    @FXML
    private ComboBox<String> channel ;
    @FXML
    private TextField delay ;
    @FXML
    private Button start ;

    @FXML
    private void startRecording(ActionEvent event) {
        String channelName = channel.getValue();
        long delayTime = Long.parseLong(delay.getText());
        // ...
    }
}