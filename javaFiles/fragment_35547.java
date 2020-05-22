public class MyTableView<T> extends TableView<T> {

    public MyTableView() {
        setRowFactory(tv -> {
            TableRow<T> row = new TableRow<>();
            row.setOnContextMenuRequested(e -> {
                if (row.isEmpty()) {
                    e.consume();
                }
            }
            return row ;
        });
    }

    // ...
}