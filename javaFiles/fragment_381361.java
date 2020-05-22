public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TableColumn<GroceryCounter, Number> TransCol = new TableColumn("transactionFee");
        TransCol.setCellValueFactory(cellData -> cellData.getValue().transactionFeeProperty());
        TableColumn<GroceryCounter, Number> priceCol = new TableColumn("price");
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        TableColumn<GroceryCounter, Number> volumeCol = new TableColumn("volume");
        volumeCol.setCellValueFactory(cellData -> cellData.getValue().volumeProperty());
        GroceryCounter item = new GroceryCounter();
        item.setPrice(10);
        item.setVolume(10);
        TableView<GroceryCounter> table = new TableView();
        table.getColumns().addAll(volumeCol, priceCol, TransCol);
        table.getItems().add(item);
        AnchorPane root = new AnchorPane();
        root.getChildren().add(table);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(args);
    }
}