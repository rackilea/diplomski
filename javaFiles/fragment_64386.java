public class USPSCaseSpinController implements Initializable {

    @FXML
    private ImageView setUSPImage;

    @FXML
    private void handleSpinMechBack(MouseEvent event) throws IOException{
    Parent handleInventoryBackParent = FXMLLoader.load(getClass().getResource("/csgocaseopener/OpenCase.fxml"));
    Scene OPBackScene = new Scene(handleInventoryBackParent);
    Stage handleInventoryBackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    handleInventoryBackStage.setScene(OPBackScene);
    handleInventoryBackStage.show();
    }

    @FXML
    private void SpinUSPSCase(ActionEvent event) throws IOException{

        //call from here
        YourAnotherClass test = new YourAnotherClass();
        test.LeadConduitUSPS(USPImage);
    }

    @FXML
    public void SetUSPImage(){
        setUSPImage.setImage(new Image("AWPCase.png"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    } 
}