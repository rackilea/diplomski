public class MainController
        implements Initializable {


    @FXML
    private TabPane tabPane;
    @FXML
    private Tab formTabPage;
    @FXML
    private FormController formTabController; // change name to this
    @FXML
    private Tab statsTabPage;
    @FXML
    private StatController statsTabController; // change name to this

    private MainApp mainApp;


    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
    }


    @Override // rename your init() method to this
    public void initialize(URL location, ResourceBundle resources) {

        // add this line
        formTabController.setStatController(statTabController);
    }
}