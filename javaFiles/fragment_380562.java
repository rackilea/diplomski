private static void selectAllBoxes(ActionEvent e) {
    CustomTableView<GeneratedPersistableBeanFX> table = getTableViewFromCheckBox(((CheckBox) e.getSource()).getParent());
    if (table == null) {
        return;
    }
    ObservableList<GeneratedPersistableBeanFX> items = table.getItems();
    for (GeneratedPersistableBeanFX item : items) {
        item.setSelectedInGrid(((CheckBox) e.getSource()).isSelected());
        table.fireEvent(new CustomTableColumnSelectionChangedEvent(item, ((CheckBox) e.getSource()).isSelected()));
    }
}
 cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    @SuppressWarnings("unchecked")
    @Override
    public void handle(MouseEvent event) {
        SimpleBooleanProperty sp = (SimpleBooleanProperty) (((TableCell<GeneratedPersistableBeanFX, Boolean>) event.getSource())
            .getTableColumn().getCellObservableValue(((TableCell<GeneratedPersistableBeanFX, Boolean>) event.getSource()).getIndex()));
        if (sp == null) {
            return;
        }
        if (sp.getValue() == false) {
            sp.setValue(true);
        }
        else {
            sp.setValue(false);
        }
        ((TableCell<GeneratedPersistableBeanFX, Boolean>) event.getSource()).getTableView().fireEvent(
            new CustomTableColumnSelectionChangedEvent((GeneratedPersistableBeanFX) ((TableCell<GeneratedPersistableBeanFX, Boolean>) event
            .getSource()).getTableRow().getItem(), sp.getValue().booleanValue()));

    }
});