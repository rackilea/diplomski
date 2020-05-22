public class ConnectionTab extends Tab {

    // @FXML-annotated controls...


    public ConnectionTab() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/connectionTab.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (Exception exc) {
            // ...
        }
    }

    // controller methods, etc...
}