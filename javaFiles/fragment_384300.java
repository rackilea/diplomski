@FXML
public void initialize() {
    bQuit.setOnAction(event -> Platform.exit());
    bConnect.setOnAction(d -> serverConnection());
    aliasField.setOnAction(a -> {

        alias = aliasField.getText();

        Input.setOnAction(b -> {
            userAnswer = Input.getText();
        });
    });
    aliasField.setPromptText("Alias");
    Input.setPromptText("And your answer is:");
}

public void main(String[] args) {
}

public void serverConnection() {
    try {
        ServerSocket quizSocket = new ServerSocket(serverPort);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ExecutorService executor = Executors.newFixedThreadPool(10000);

    Task<Void> connection = new Task<Void>() {