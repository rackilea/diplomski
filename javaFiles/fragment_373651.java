public class Controller {

    @FXML
    private ComboBox<String> combomain;
    static String getData = "QueryHEre";

    @FXML
    void initialize() {
        empnames = queryDatabase(getData);
        String[] names = empnames.toArray(new String[0]);

        combomain.getItems().addAll(names);
        combomain.setValue("");
    }

}