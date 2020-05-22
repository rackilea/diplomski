try {
    con = DriverManager.getConnection(...);
    ps = con.prepareStatement(query);
    ps.setString(1, userID);
    ps.setString(2, bookID);
    ResultSet rs= ps.execute();

    if (!rs.isBeforeFirst() ) {    
          System.out.println("empty"); 
          return false;
    }else {
          System.out.println("with data"); 
          return true;
    }

} catch (SQLException sqle) {
    sqle.printStackTrace();
    return false;
}