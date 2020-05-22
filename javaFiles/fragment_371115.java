public class SampleController implements Initializable {

    @FXML
    private NumberAxis xAxis ;

    @FXML
    private NumberAxis yAxis ;

    // never initialize fields that are injected by @FXML:
    // they are initialized by the FXMLLoader
    @FXML //  fx:id="Ch"
    private LineChart<Number, Number> Ch ;

    // ...
}