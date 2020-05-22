table.setRowFactory(new Callback<TableView<DataRow>, TableRow<DataRow>>() {
        @Override
        public TableRow<DataRow> call(TableView<DataRow> tableView) {
            final TableRow<DataRow> row = new TableRow<DataRow>() {
                @Override
                protected void updateItem(DataRow row, boolean empty) {
                    super.updateItem(row, empty);
                    if (!empty)
                        styleProperty().bind(Bindings.when(row.selectedProperty())
                            .then("-fx-font-weight: bold; -fx-font-size: 16;")
                            .otherwise(""));
                }
            };
            return row;
        }
    });