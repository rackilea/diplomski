public void updateUnsubscribe(String empid) { 
  PreparedStatement ps = conn.prepareStatement("update MYDB set edate=? where emp=?");
  ps.setTimestamp(1, new java.sql.Timestamp(new Date()));
  ps.setString(2, empid);
  ps.executeUpdate();
}