String queryString = "";
String selectedItem = (String) searchTypeCmb.getSelectedItem();
String searchTerm = searchTermField.getText();
String id = theId.getText();
textArea.setText("");
try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dealer", "root", "admin")) {

    PreparedStatement stmt = null;
    if ("Phone".equals(selectedItem)) {
        stmt = connection.prepareStatement("UPDATE person SET phone = ? WHERE driverID = ?");
    } else if ("Address".equals(selectedItem)) {
        stmt = connection.prepareStatement("UPDATE person SET address = ? WHERE driverID = ?");
    }
    if (stmt != null) {
        stmt.setString(1, searchTerm);
        stmt.setString(2, id);
        stmt.executeUpdate();
    }