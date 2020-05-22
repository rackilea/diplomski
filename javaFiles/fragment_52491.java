public void closeConnection(Connection conn) {
   try {
        conn.close();
   } catch(SQLException sqlexe) {
     // Connection closing failed
    //Log exception
  }
}