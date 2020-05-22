public class MyTableView<T> extends TableView<T> {

    private final ContextMenu contextMenu ;

    public MyTableView(ContextMenu contextMenu) {
        this.contextMenu = contextMenu ;

        setRowFactory(r -> {
            TableRow<ObservableList<String>> row = new TableRow<ObservableList<String>>() {
                public void updateItem(ObservableList<String> item, boolean empty) {
                    super.updateItem(item, empty);
                    if (isEmpty()) {
                        setContextMenu(null);
                    } else {
                        setContextMenu(contextMenu);
                    }
                }
            };
        });

    }

    // ...
}