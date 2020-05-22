ObservableMap<String, String> map = FXCollections.observableHashMap();

ObservableList<String> keys = FXCollections.observableArrayList();

map.addListener((MapChangeListener.Change<? extends String, ? extends String> change) -> {
    boolean removed = change.wasRemoved();
    if (removed != change.wasAdded()) {
        // no put for existing key
        if (removed) {
            keys.remove(change.getKey());
        } else {
            keys.add(change.getKey());
        }
    }
});

map.put("one", "One");
map.put("two", "Two");
map.put("three", "Three");

final TableView<String> table = new TableView<>(keys);

TableColumn<String, String> column1 = new TableColumn<>("Key");
// display item value (= constant)
column1.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue()));

TableColumn<String, String> column2 = new TableColumn<>("Value");
column2.setCellValueFactory(cd -> Bindings.valueAt(map, cd.getValue()));

table.getColumns().setAll(column1, column2);