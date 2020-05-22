levelChoice = FXCollections.observableArrayList("Bla", "Blo");

levelColumn.setCellValueFactory(
    new PropertyValueFactory<ClassesProperty, String>("level")
);
levelColumn.setCellFactory(ComboBoxTableCell.forTableColumn(levelChoice));
levelColumn.setOnEditCommit(
    new EventHandler<CellEditEvent<ClassesProperty, String>>() {
        @Override
        public void handle(CellEditEvent<ClassesProperty, String> t) {
            ((ClassesProperty) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLevel(t.getNewValue());
        };
    }
);