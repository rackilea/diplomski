public class NavigationPresenter implements Initializable {

    @FXML
    Button atNavButton;

    @Inject
    private ViewState viewState ;

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
    }

    @FXML
    void showDfdScene(ActionEvent event) {
        viewState.setAtShowing(true);
    }  
}