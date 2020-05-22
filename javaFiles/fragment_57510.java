private void filterList() {

        // Hide columns
        for (TableColumn column : table.getColumns()) {
            if (!((String) column.getHeaderValue()).toLowerCase().contains(
                    searchBox.getText().toLowerCase().trim())) {
                hiddenModel.addColumn(column);
                table.getColumnModel().removeColumn(column);
            }
        }

        // Show columns
        for (TableColumn column : hiddenTable.getColumns()) {
            if (((String) column.getHeaderValue()).toLowerCase().contains(
                    searchBox.getText().toLowerCase().trim())) {
                table.getColumnModel().addColumn(column);
                hiddenModel.removeColumn(column);
            }
        }
    }