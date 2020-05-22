static void update(TableCell<TimeTable, String> cell, String newValue) {
    ((TableRow<TimeTable>)cell.getTableRow()).getItem().setDay(newValue);
    // the below line would be needed, if the setter does not trigger
    // a update of the ObservableValue returned by the cellValueFactory
    // cell.getTableView().refresh();
}