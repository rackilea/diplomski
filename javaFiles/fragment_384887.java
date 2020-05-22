public class ViewAController {
    @FXML
    private Button btnL, btnR;

    @FXML
    private void initialize() {
        btnL.setOnAction(event -> Mediator.getInstance().fireEvent("left"));
        btnR.setOnAction(event -> Mediator.getInstance().fireEvent("right"));
    }
}

public class ViewBController {

    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        Mediator.getInstance().register(s -> {
            switch (s) {
                case "left":
                    tabPane.getSelectionModel().select(0);
                    break;

                case "right":
                    tabPane.getSelectionModel().select(2);
                    break;
            }
        });
    }
}