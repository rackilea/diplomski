String sql = "select * from tablename where id = ? AND case_id = ?";

PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, 1);
ps.setString(2, "1000");

ResultSet rs = ps.executeQuery();