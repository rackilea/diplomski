public void dbconnection() {

    String name = "";
    String port = "3306";
    String user = "systech";
    String pass = "systech";
    String dbname = "cascade_demo";
    String host="192.168.1.61";

    try {
        String url = "jdbc:mysql://"+host+":"+  port + "/" + dbname;
        Class.forName("com.mysql.jdbc.Driver").newInstance ();
        Connection con = DriverManager.getConnection(url, user, pass);
        String qry2 = "select * from item_master";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry2);
        while (rs.next()) {
            System.out.println("Name:" + rs.getString(1));
        }

        rs.close();
        st.close();
        con.close();


    } catch (Exception e) {
        System.out.println("Exception:" + e);
    }
}