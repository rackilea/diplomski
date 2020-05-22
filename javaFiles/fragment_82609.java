public class JavaChat extends Application 
{   
    @Override
    public void start(Stage stage) throws Exception {
        // Create and set up scene...
        FMXLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = (FXMLDocumentController) loader.getController();
        Scene scene = new Scene(root);
        // Establish connection to server...
        Connection.createNewConnection();
        // Create new reader thread...
        Thread readerThread = new Thread(new IncomingReader(controller));
        readerThread.start();
        // When all done...
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}