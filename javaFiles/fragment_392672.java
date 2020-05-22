String sql="Update Personal_Info set first_name=? where emp_id='2011-01015'";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1,getFirstName()); // set parameter value for first_name
ps.executeUpdate();
ps.close();
conn.close();