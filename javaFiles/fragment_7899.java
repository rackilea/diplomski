TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        BrandManifestCustom bmc = tableView.getItems().get(row);
        TableColumn col = pos.getTableColumn();
        if (col.getCellObservableValue(bmc).getValue() instanceof Products) {
            System.out.println("hey Products");
        }
        if (col.getCellObservableValue(bmc).getValue() instanceof Brand) {
            System.out.println("hey Brand");
        }