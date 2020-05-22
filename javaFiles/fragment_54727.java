public class JavaFXMLApplication3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      //  Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       // FXMLLoader loader

        Parent loaded=null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
    try {
        loaded = (Parent) loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene scene = new Scene(loaded);

        stage.setScene(scene);
        stage.show();
    FXMLDocumentController controller = (FXMLDocumentController) loader.getController();

    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            Pane pane = controller.getPane();
            pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    });


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }