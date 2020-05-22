public class Controller {

    private static final int MAX_LIST_VIEW_ITEMS = 5_000 ;

    private ObservableList<String> listData = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listView ;

    public void initialize() {
        listView.setItems(listData);
        // ...
    }

    public void addToListView(List<String> itemsToAdd) {
        listData.addAll(itemsToAdd);
        int excess = itemsToAdd.size() - MAX_LIST_VIEW_ITEMS ;
        if (excess > 0) {
            listData.subList(0, excess).clear();
        }
    }

    // ...
}