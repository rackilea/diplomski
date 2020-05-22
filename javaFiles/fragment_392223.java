String sql = 
        "DELETE t1.*, t2.*, t3.* " +
        "FROM " +
            "(" +
                "Table1 AS t1 " +
                "INNER JOIN " +
                "Table2 AS t2 " +
                    "ON t2.ID=t1.ID " +
            ")" +
            "INNER JOIN " +
            "Table3 AS t3 " +
                "ON t3.ID=t2.ID " +
        "WHERE t1.ID=?";
ps = con.prepareStatement(sql);
ps.setInt(1, 4);  // delete where ID=4
int n = ps.executeUpdate();