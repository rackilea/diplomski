private static TextField total;
private static ObservableList<String> items;

@Override
public void start(Stage arg0) throws Exception {
    total = new TextField();
    items = FXCollections.observableArrayList(); 
    model = new Main2Model();
    c = model.getCompanyList();
    primaryStage = arg0;
    primaryStage.setTitle("MallApp");
    primaryStage.centerOnScreen();
    showMainView();
}