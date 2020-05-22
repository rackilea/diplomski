public class MenuController extends AbstractController implements Initializable {
    // ...

    @Inject
    MainService mainService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        disableMenuElements();
        mainService.currentProgramProperty().addListener((observable, oldValue, newValue) -> {
            // ...
        });
    }
}