@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    try {
        Tab tab = new Tab();
        tabPane.getTabs().add(tab);
        tab.setContent((Node) FXMLLoader.load(this.getClass().getResource("main.fxml")));
    } catch (IOException e) {
        e.printStackTrace();
    }
}