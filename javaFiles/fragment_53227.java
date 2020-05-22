String query = "insert into your_table_name(`name`,`myDate`) values(?,?)";
PreparedStatement ps = conn.prepareStatement(query);
//now just set the values like this
ps.setString(1,"ABC");
//note index starts at 1
ps.setDate(2,sqlDate);
ResultSet rs = ps.executeQuery();