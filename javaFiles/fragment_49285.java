public void connectionexample(String email)
{
  Connection conn = null;
  PreparedStatement ps = null;
  PreparedStatement ps2 = null; -- Use another variable for the second prepared statement
  ResultSet rs = null;        
  try {            
    conn = db.getConnection();            
    ps = conn.prepareStatement(select_query);            
    ps.setString(1, email);
    rs = ps.executeQuery();
    if(rs.next()) {
      ps2 = conn.prepareStatement(update_query); -- Assign this to the second variable
    } else {
      ps2 = conn.prepareStatement(insert_query);                  
    }            
    ps2.setString(1, email);
    ps2.executeUpdate();             
  } catch(Exception e) {                    
    LOG.error("Exception occured ", e);                     
  } finally {                    
    DATABASE.release(rs);
    DATABASE.release(ps);
    DATABASE.release(ps2);  -- Make sure you also close the second prepared statement
    DATABASE.release(conn);
  }
}