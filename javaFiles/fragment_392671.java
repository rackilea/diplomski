String sql="Update Personal_Info set first_name=? where emp_id=?";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1,getFirstName()); // set parameter value for first_name
ps.setString(2,"2011-01015");   //     parameter value for emp_id    
ps.executeUpdate();
ps.close();
conn.close();