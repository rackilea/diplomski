public class RootController implements Initializable {

    @FXML
    private ComponentController componentController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // getting Entity from a service or from any other sources
        //You may replace this line with an appropriate one for you.
        Entity entity = getEntity();
        componentController.setEntity(entity);
    }
}