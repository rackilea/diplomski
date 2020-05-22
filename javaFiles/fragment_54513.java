datesColumn.setCellFactory(param -> new ComboBoxTableCell<Item,LocalDate>(){
      @Override public void startEdit() {
                Item item = (Item)getTableRow().getItem();
                getItems().setAll(item.getDates());
                super.startEdit();
        }
});