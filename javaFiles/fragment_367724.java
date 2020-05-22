public class Controller {

    @FXML
    private ListView templates;
    @FXML
    private ImageView image;

    @FXML
    // void initalize() {
    void initialize() {
        ObservableList elements = FXCollections.observableArrayList();
        elements.add("first");
        elements.add("second");
        elements.add("third");
        image.setImage(new Image("file:test.jpg"));
        templates.setItems(elements);
    }

}