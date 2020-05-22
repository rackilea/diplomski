public static void customersSelectWhere(JPanel customers, int CustID) {
    CustomersTable();
    String[] entries = new String[7];
    Connection c = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        // You should not need Class.forName anymore.
        // Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:WalkerTechCars.db");
        c.setAutoCommit(false);

        String query = "SELECT * FROM CUSTOMERS WHERE CUSTID=?";
        // ResultSet rs = pstmt.executeQuery( query );
        pstmt = c.prepareStatement(query);
        pstmt.setInt(1, CustID);
        rs = pstmt.executeQuery();
        // c.commit();
        while (rs.next()) {
            // Make it a String to begin with.
            // String custId = rs.getString("custID");
            String custId = Integer.toString(CustID);
            String phone = rs.getString("phone");
            String surname = rs.getString("surname");
            String firstname = rs.getString("firstname");
            String home = rs.getString("home");
            String address = rs.getString("address");
            String postcode = rs.getString("postcode");
            customers.add(customersTableSingle(custId, firstname, surname,
                    phone, home, address, postcode, false, customers));
        }
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }