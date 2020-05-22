public class MyTableView<T> extends TableView<T> {

    private ContextMenu rowContextMenu ;

    public ContextMenu getRowContextMenu() {
        return rowContextMenu ;
    }

    public void setRowContextMenu(ContextMenu contextMenu) {
        this.rowContextMenu = contextMenu ;

        setRowFactory(r -> new TableRow<ObservableList<String>>() {
            public void updateItem(ObservableList<String> item, boolean empty) {
                super.updateItem(item, empty);
                if (isEmpty()) {
                    setContextMenu(null);
                } else {
                    setContextMenu(rowContextMenu);
                }
            }
        });
    }

    // ...
}