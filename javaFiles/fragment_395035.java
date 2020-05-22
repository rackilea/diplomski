public String getData(String u) {
    try {
         //Register JDBC driver
         Class.forName("com.exasol.jdbc.EXADriver");

         try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
             //Execute a Query
             String data = "SELECT USERNAME, PASSWORD FROM ES.USERS WHERE USERNAME = ?";
             PreparedStatement st = con.prepareStatement(data);
             st.setString(1, u);

             ResultSet rs = st.executeQuery();

             if (rs.next()) {
                 return rs.getString("PASSWORD");
             } else {
                 return null;
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }

     return null;

 }