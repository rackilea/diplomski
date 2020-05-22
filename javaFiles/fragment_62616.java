public class SampleController {

    private ObservableList<Model> tableData = FXCollections.observableArrayList();
    @FXML
    private TableView<RowModel> table ;
    @FXML
    private TableColumn<Model, String> firstCol ;
    @FXML
    private TableColumn<Model, String> secondCol ;

    @FXML
    public void initialize() {
        table.setEditable(false);
        firstCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        secondCol.setCellValueFactory(cellData -> cellData.getValue().getProgress());
        table.setItems(tableData);
    }
    public void addModel(ChannelFuture sendFileFeture,Model model){
        table.getItems().add(model);
        System.out.println("row model= "+model.getName().get());// it works fine;
        sendFileFeture.addListener(rowModel);
    }

}