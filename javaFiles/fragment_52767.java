Timestamp t = ???;


   String sql = "SELECT * FROM table WHERE timestamp_column = ?";
   preparedStatement = conn.prepareStatement(sql);
   preparedStatement.setTimestamp(t);