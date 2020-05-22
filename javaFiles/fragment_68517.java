public class ConsoleController implements Initializable {

    Thread t;
    @FXML
    private Label totalM;
    @FXML
    private Label freeM;
    @FXML
    private Label maxM;
    @FXML
    private TextArea consoleTextArea;

    private Console console;
    private PrintStream ps;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        console = new Console(consoleTextArea);
        ps = new PrintStream(console, true);

        redirectOutput(ps);


        t = new Thread(() -> {
            while (true) {
                try {
                    Platform.runLater(() -> {
                        updateMemInfo();
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        });
        t.setPriority(Thread.MIN_PRIORITY);
        t.setName("MemUpdateInfoThread");
        t.setDaemon(true);
        t.start();

    }

    // other methods as before...
}