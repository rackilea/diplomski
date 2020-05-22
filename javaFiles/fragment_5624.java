Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM STACKOVERFLOW.information_schema.tables ORDER BY TABLE_NAME");

while (rs.next()) {
    String name = rs.getString("TABLE_NAME");
    ExtractFrom.addItem(name);

    if (name.toLowerCase().equals("stack")) {
        pvIsPresent = true;
        break;
    }
}

while (rs.next()) {
    String name = rs.getString("TABLE_NAME");
    ExtractFrom.addItem(name);
}

if (pvIsPresent)
    ExtractFrom.setSelectedItem("stack");