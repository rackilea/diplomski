public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane redPane;

    @FXML
   private void changeGridSize(ActionEvent event){
      // new ChangeSizes();
   }


    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    

    public Pane getPane(){
        return this.redPane;
    }

}