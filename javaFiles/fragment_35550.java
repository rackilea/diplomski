public class MyTableView<T> extends TableView<T> {

    public MyTableView() {
        contextMenuProperty().addListener((obs, oldContextMenu, newContextMenu) -> {
            if (newContextMenu == null) {
                setRowFactory(r -> new TableRow<>());
            } else 
                setRowFactory(r -> new TableRow<ObservableList<String>>() {
                    public void updateItem(ObservableList<String> item, boolean empty) {
                        super.updateItem(item, empty);
                        if (isEmpty()) {
                            setContextMenu(null);
                        } else {
                            setContextMenu(newContextMenu);
                        }
                    }
                });
            }
        });
    }

    // ...
}