PreparedStatement ps = connection.prepareStatement(above_sql_as_string);

// To get total salary of 10 and 20 department_id:
ps.setInt(1, 10);
ps.setInt(2, 20);

ResultSet rs = ps.executeQuery();