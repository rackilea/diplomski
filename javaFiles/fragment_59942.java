public void moveTableItem(Table table, int from, int to) {
    TableItem item2Move = table.getItem(from);
    TableItem newTableItem = new TableItem(table, SWT.NONE, to);
    newTableItem.setText(item2Move.getText());
    // You may want to clone the entire item here; and not just the text.

    // Dispose off, the old item.
    item2Move.dispose();

}