col_action = new TableColumn<>("Action");
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Record>, 
                ObservableValue<Record>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Record> p) {
                return new ReadOnlyObjectWrapper<Record>(p.getValue());
            }
        });



        col_action.setCellFactory(
                new Callback<TableColumn<Record, Record>, TableCell<Record, Record>>() {

            @Override
            public TableCell<Record, Record> call(TableColumn<Record, Record> p) {
                return new ButtonCell();
            }

        });