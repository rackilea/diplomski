public class MenuController extends AbstractController implements Initializable {
    // ...

    private MainService mainService;

    @Inject
    public void setMainService(MainService mainService) {
        this.mainService = mainService ;
        mainService.currentProgramProperty().addListener((observable, oldValue, newValue) -> {
           //  ...
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        disableMenuElements();
    }
}