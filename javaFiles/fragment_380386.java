public static ObservableList<Customer> search_ForDropDown(String searchQuery){
    MysqlDataSource dataSource = CurrentServer.getDataSource();
    ObservableList<Customer> data = FXCollections.observableArrayList();
    data.clear();

    try {
        String query = "SELECT * FROM CUSTOMER LIMIT 5";

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);     

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setID(rs.getInt("id"));
            customer.setPhoneNumber(rs.getString("phoneNumber"));
            customer.setEmailAddress(rs.getString("emailAddress"));

            data.add(customer);
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }       
    return data;
}