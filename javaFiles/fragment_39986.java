public class Main extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Log stuff");
        btn.setOnAction(a-> {
            LOG.info("This is some info");
            LOG.error("This is some error");
        });

        TextArea textArea = new TextArea();
        OutputStream os = new TextAreaOutputStream(textArea);

        MyStaticOutputStreamAppender.setStaticOutputStream(os);

        GridPane grid = new GridPane();
        grid.add(textArea, 0 ,0);
        grid.add(btn, 0, 1);
        primaryStage.setScene(new Scene(grid, 500, 250));
        primaryStage.show();
    }

    private static class TextAreaOutputStream extends OutputStream {

        private TextArea textArea;

        public TextAreaOutputStream(TextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            textArea.appendText(String.valueOf((char) b));
        }
    }
}