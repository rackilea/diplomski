DbManager db = (DbManager) getServletContext().getAttribute("Database");
    Connection con = db.getConnection();
    try {
        String query = "INSERT into ADD_CUSTOMER values ('" + customer.getFirstName() + "','" + customer.getLastName() + "','" + customer.getAddress() + "','" + customer.getCity() + "','" + customer.getPostalCode() + "','" + customer.getEmail() + "'," + customer.getPhoneNumber() + ",'" + customer.getUserEmail() + "'," + customer.getCustomerType() + ")";
        Statement st = con.createStatement();
        st.executeUpdate(query); //Error Handling to be done
        st.close();
    } catch (Exception e) {
        System.out.println(e);
    }