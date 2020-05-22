class MyTableCell<S,T> extends TableCell<S, T>

@Override
public void updateItem(final T item, final boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
        this.setText(null);
        this.setGraphic(null);
    } else {
        S item = (S) this.getTableRow().getItem();
        // DO STUFF HERE
    }
}
}