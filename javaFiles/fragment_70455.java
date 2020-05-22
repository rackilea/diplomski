public void actionPerformed(ActionEvent e) {
    String query = "INSERT INTO racebikes"
            + "(bikename, country_of_origin, cost) VALUES"
            + "(?,?,?)";

    // TODO: Connection management?
    PreparedStatement statement = conn.prepareStatement(query);
    try {
        statement.setString(1, (String)winners_combo_box.getSelectedItem());
        statement.setString(2, winner_fields[0].getText());
        statement.setFloat(3, Float.parseFloat(winner_fields[1].getSelectedText()));
        statement.executeUpdate();
    } catch(SQLException e1) {
        e1.printStackTrace();
        // TODO: Don't just pretend it worked...
    } finally {
        statement.close();
    }
}