class DataRetrieve {

    DataRetrieve() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "1234");
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from contacts");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet() {
          return rs;
    }
private ResultSet rs = null;
}