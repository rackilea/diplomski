String sql = "INSERT INTO [" + tableName + "] (SUBJID, PARAMCD, PARAM, AVAL) VALUES (?,?,?,?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, a);
ps.setString(2, s1);
ps.setString(3, s2);
ps.setDouble(4, b);
ps.executeUpdate();