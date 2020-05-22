@FXML
private AnchorPane inputRoot;
private BooleanBinding gt600;

@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    gt600 = inputRoot.widthProperty().greaterThan(600);
    gt600.addListener((observable, newvalue, oldvalue) -> {
        System.out.println(newvalue.toString());
    });
}