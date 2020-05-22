public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/software", "root", "usbw");
    Statement st = con.createStatement();
    String query="select * from football";
    ResultSet rs = st.executeQuery(query);
    System.out.print("Records from the database");
    while(rs.next()){
        String name = rs.getString("Name");
        System.out.print("Name: "+name+" ");
    }
}