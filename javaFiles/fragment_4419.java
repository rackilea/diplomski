private void fillColumns() {
    try { // starting from 2 so that the id column is not included
        for (int i = 2; i <= resultSet.getMetaData().getColumnCount(); i++ ) {
            TableColumn column = new TableColumn(resultSet.getMetaData().getColumnName(i));
            column.setCellValueFactory(new PropertyValueFactory<Contact, String>(Contact.getFieldNames()[i - 1]));
            selectedTable.getColumns().add(column);              
        }
    } catch (SQLException ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Type:\n" + ex.getClass().getName() + "\n\nMessage: Unable to get the columns from the database\n\nDetails:\n" + ex.getMessage(), ButtonType.OK);
    }    
}