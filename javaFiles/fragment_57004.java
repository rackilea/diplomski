Connection con = GetCon.getCon();
Statement statement = con.createStatement();
try {
  ResultSet resultset = statement.executeQuery("SELECT MarketPlace,OrderDate, ROUND(SUM(Total),2),  COUNT(*) , ROUND(ROUND(SUM(Total),2)/ COUNT(*),2) FROM vend_printed WHERE OrderDate >=" +newtime+ " GROUP BY OrderDate,MarketPlace") ;
  while(resultset.next()){
  markets.add(new Market(
    resultset.getString(1),
    resultset.getString(2),
    resultset.getDouble(3),
    resultset.getInt(4),
    resultset.getDouble(5)
  ));
  }
} finally {
  try {
    statement.close();
  } catch (SQLException e) {}
}