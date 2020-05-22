package controller;
public class MainController extends BaseController{

    // field names are formed by appending "Controller" to the fx:id attribute value:
    @FXML
    private ControlsController ControlsViewController;
    @FXML
    private ParametersController ParametersViewController;
    @FXML
    private CashRegisterController CashRegisterViewController;

    // Remove this constructor:
    // public MainController() {
        //controlsController = Controller.getInstance().getControlsController();
        //parametersController = Controller.getInstance().getParametersController();
        //cashRegisterController = Controller.getInstance().getCashRegisterController();
    // }

    public void initialize() {
        // give ControlsViewController access to CashRegisterViewController:
        ControlsViewController.setCashRegisterViewController(CashRegisterViewController);
    }
}