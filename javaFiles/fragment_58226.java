public class FormController {


    Activities act = new Activities();
    List<Activity> activities = act.getActivityList();

    private ObservableList<String> opt = FXCollections.observableArrayList(
            "Option 1",
            "Option 2",
            "Option 3"
    );
    @FXML
    private Button calculateButton;
    @FXML
    private TextField numberField;
    @FXML
    private ComboBox<String> options;
    private String selectedOption;
    private StatController statController; // add this member


    @FXML
    private void initialize() {

        options.getItems().addAll(opt);
        options.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                        selectedOption = newValue;
                    }
                });
    }


    @FXML
    public void calculateButtonClicked() {
        // change this method here
        statController.setActivityData(act);
    }

    // add this method here
    public void setStatController(StatController statController) {

        this.statController = statController;
    }
}