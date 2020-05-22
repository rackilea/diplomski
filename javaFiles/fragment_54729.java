public class JavaFXMLApplication3 extends Application {

  static Stage staticstage;

      //  Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       // FXMLLoader loader

   @Override
public void start(Stage stage) throws Exception {
  //  Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
   // FXMLLoader loader
   staticstage=stage;
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



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}