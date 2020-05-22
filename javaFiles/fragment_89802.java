public void myListener(ValueChangeEvent event) {
    int index = dataModel.getRowIndex();
    Item item = dataModel.getRowData();
    Object oldValue = event.getOldValue();
    Object newValue = event.getNewValue();
    // ...
}