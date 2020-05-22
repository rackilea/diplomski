import net.proteanit.sql.DbUtils;


  try {
    st = conn.createStatement();
    st.executeQuery(q);
    ResultSet rs = st.executeQuery(q);
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       }
  catch (SQLException ex) {
  JOptionPane.showMessageDialog(null, ex);
   } finally {
     try {
    rs.close();
  } catch (SQLException e) { /* ignore */
  }

  try {
    st.close();
  } catch (SQLException e) { /* ignore */
 }
  }