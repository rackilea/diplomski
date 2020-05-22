private void fillRows() {
    shownRecords = 0;
    try {
        while(resultSet.next()) {
            Contact cont = new Contact(Integer.toString(resultSet.getInt(1)), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));
            tableView.getItems().add(cont);
        }
        resultSet.beforeFirst();
    } catch (SQLException ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Type:\n" + ex.getClass().getName() + "\n\nMessage: Unable to get the records from the database\n\nDetails:\n" + ex.getMessage(), ButtonType.OK);
        alert.show();
    }
}