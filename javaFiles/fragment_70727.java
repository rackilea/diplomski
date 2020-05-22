private static TextField total = new TextField();
private static ObservableList<String> items = FXCollections.observableArrayList();

public void start(Stage arg0) throws Exception {
    model = new Main2Model();
    c = model.getCompanyList();
    primaryStage = arg0;
    primaryStage.setTitle("MallApp");
    primaryStage.centerOnScreen();
    showMainView();
}