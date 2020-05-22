try(Connection con = getConnection()) {
   try (PreparedStatement prep = con.prepareConnection("Update ...")) {
       //prep.doSomething();
       //...
       //etc
       con.commit();
   } catch (SQLException e) {
       //any other actions necessary on failure
       con.rollback();
       //consider a re-throw, throwing a wrapping exception, etc
   }
}