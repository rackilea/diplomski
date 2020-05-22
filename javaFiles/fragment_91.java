JComboBox<Client> comboBox = new JComboBox<>();
try {
    String sql="SELECT clientid,name,lastname FROM client";
    conn = DBConnector.getConnection();
    state = conn.prepareStatement(sql);
    result = state.executeQuery();
    while(result.next()) {
        int id = result.getInt("clientid");
        String name = result.getString("name");
        String lname = result.getString("lastname");
        comboBox.addItem(new Client(id, name, lname));
    }
} catch (Exception e) {
    e.printStackTrace();
}