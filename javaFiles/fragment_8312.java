public void copyTableViewDeleteRow(int j)
{
    ArrayList<ListOrderedMap<String, CellDescriptor>> newData = new ArrayList<>();

    //TODO
    ObservableList<TableColumn<ObservableMap<String, CellDescriptor>, ?>> columns = tableView.getColumns();

    ListOrderedMap<String, CellDescriptor> rowHeader = new ListOrderedMap<>();

    int rowIndex = 0;
    int columnIndex = 0;
    for (TableColumn<?, ?> column : columns) {
        String cell = column.getText();
        String key = COLUMN_KEY_PREFIX + Integer.toString(columnIndex);
        CellDescriptor cd = new CellDescriptor(columnIndex, rowIndex, cell, this);
        rowHeader.put(key, cd);

        ++columnIndex;
    }

    newData.add(rowHeader);     

    ObservableList<ObservableMap<String, CellDescriptor>> items =
            tableViewCopy.getItems();

    ++rowIndex;
    for (Object row : tableView.getItems()) {
        ListOrderedMap<String, CellDescriptor> newRow = new ListOrderedMap<>();

        columnIndex = 0;
        for (TableColumn column : columns) {

            CellDescriptor cd = (CellDescriptor) column.getCellObservableValue(row).getValue();
            CellDescriptor cdNew = cd.clone();

            if(rowIndex == 1 && columnIndex == 1)
                cdNew.setText("xxx");

            newRow.put(COLUMN_KEY_PREFIX + columnIndex, cdNew);
            ++columnIndex;
        }

        items.add(e);
        newData.add(newRow);

        ++rowIndex;
    }       

    this.data = newData;
}