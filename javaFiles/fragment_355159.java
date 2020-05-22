public class FXMLController implements Initializable {
    String testVar;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea testTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void initData(Remote remoteObj) {
        this.testVar = remoteObj.getVar();
        testTextArea.appendText("TestVar: " + testVar);
    }    
}