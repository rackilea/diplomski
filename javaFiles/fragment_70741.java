public class SpecialAnchorClass extends AnchorPane implements Initializable{

    //..@fxml nodes

    /**
     * Constructor
     */
   public SpecialAnchorClass(){
         //FXMLLOADER
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..path to fxml file"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   @Override
     public void initialize(URL location, ResourceBundle resources) {


           //when this method is called every fxml component has been initialized
     }

}