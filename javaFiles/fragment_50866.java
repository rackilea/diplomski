public static void quotesReader() throws ClassNotFoundException, SQLException {
  File f = new File("/Users/Adam/Desktop/SQL Folder/20070620/20070620");
  File[] files = f.listFiles();

  try {
    Class.forName("com.mysql.jdbc.Driver");
    connect = DriverManager.getConnection( 
            "jdbc:mysql://localhost:3306/newTest", "root", "Kariya"
            );
    long counter = 1; // place this before the for(int i=0...) loop
    pst = connect.prepareStatement("INSERT INTO newTestTable2(stockID, millisFromMid, bidPrice, askPrice) VALUES(?,?,?,?)");

    for( int i=0; i < files.length; i++) {
      ReadGZippedTAQQuotesFile taqQuotes = new ReadGZippedTAQQuotesFile( files[i] );
      int nRecs = taqQuotes.getNRecs();
      for( int j = 0; j < nRecs; j++ ) {
        pst.setInt(1, counter++);
        pst.setInt(2, taqQuotes.getMillisecondsFromMidnight( j ));
        pst.setDouble(3, taqQuotes.getBidPrice( j ));
        pst.setDouble(4, taqQuotes.getAskPrice( j ));
        pst.executeUpdate();
      }
    }
  } catch (IOException e1) {
    e1.printStackTrace();
  } finally {
    try {
        if (pst != null) {
            pst.close();
        }
        if (connect != null) {
            connect.close();
        }
    } catch (Exception e) {

    }
  }
}