String stmt = "INSERT INTO orders " +
              "(user_id, order_time, order_details) " + 
              "VALUES (?, ?, ?);"
PreparedStatement p = connection.prepareStatement(stmt);
p.setString(1, "Karthik");
p.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
p.setString(3, "here is some order text");