...
callstm.execute();
ResultSet rset = (ResultSet)callstm.getObject(1);
while (rset.next()){
      System.out.println(rset.getString(columnIndex));
}
// Close all the resources
...