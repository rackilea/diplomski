public class ClientController implements Controller {

    @FXML
    private TextField targetAddress;
    @FXML
    private TextField fieldUsername;
    @FXML
    private TextField fieldPort;
    @FXML
    private VBox messages;
    @FXML
    private TextField input;
    @FXML
    private Button btnConnect;

    private String username = "Anonymous";
    private int port = 2000;

    private Client client ;

    public void initialize() {
        client = new Client();
    }

    @FXML
    private void connect() {

        if (!client.connected()) {
            if (!targetAddress.getText().equals("")) {
                if (!fieldUsername.getText().equals("")) {
                    username = fieldUsername.getText();
                }
                if (!fieldPort.getText().equals("")) {
                    port = Integer.valueOf(fieldPort.getText());
                }

                try {
                    client.connect(targetAddress.getText(), username, port);
                    btnConnect.setText("Disconnect");
                    display("Attention: Successfully connected to server");
                } catch (IOException exc) {
                    display("Attention: Unable to connect to server");
                }
            } else {
                display("Attention: Address required");
            }
        } else {
            client.disconnect();
            display("Attention: Disconnecting...");
            btnConnect.setText("Connect");
        }

    }

    @FXML
    private void message() {

        if (client.connected()) {
            displayAndSend(input.getText());
            input.setText("");
        } else {
            display("Attention: Not connected to server");
            input.setText("");
        }

    }

    public void display(String message) {
        messages.getChildren().add(new Message(message));
    }

    public void displayAndSend(String message) {
        display(message);
        client.sendMessage(message);
    }

}