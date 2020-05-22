public static void main(String[] args) {
    try {
        String query = "SELECT * FROM Student";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "0");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        //Loop to retrieve tuple(s) from the ResultSet rs
        while (rs.next()) {
            String name = rs.getString("sname");
            System.out.println(name);
        }
        con.close();
    } catch (Exception e) {
    }
}