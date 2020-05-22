public class CommandLineTextAreaDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(getContent());
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }

    private BorderPane getContent() {
        TextArea textArea = new TextArea();
        TextField input = new TextField();

        input.setOnAction(event -> executeTask(textArea, input.getText()));

        BorderPane content = new BorderPane();
        content.setTop(input);
        content.setCenter(textArea);
        return content;
    }

    private void executeTask(TextArea textArea, String command) {
        Task<String> commandLineTask = new Task<String>() {
            @Override
            protected String call() throws Exception {
                StringBuilder commandResult = new StringBuilder();
                try {
                    Process p = Runtime.getRuntime().exec(command);
                    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        commandResult.append(line + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return commandResult.toString();
            }
        };

        commandLineTask.setOnSucceeded(event -> textArea.appendText(commandLineTask.getValue()));

        new Thread(commandLineTask).start();
    }
}