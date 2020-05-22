public String getAge(String name) {
    PreparedStatement pst = null;
    ResultSet rs = null;
    String userage = null;
    try {
        pst = conn.prepareStatement("select age from mydb where name= ?");
        pst.setString(1, name);

        rs = pst.executeQuery();

        while (rs.next()) {
            userage = rs.getString("age");
            System.out.println(userage);
        }

    } catch (Exception ex) {
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
       // closing JDBC resources
       if(rs != null) {
          rs.close();
       }

      if(pst != null) {
          pst.close();
       }

    return userage;
}