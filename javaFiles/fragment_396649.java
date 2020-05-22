import net.proteanit.sql.DbUtils;
//
//
//
try {
        conn = SQLConnect.ConnectDb();
        String sql = "SELECT * FROM CriminalRecords WHERE FName = ? and Sname = ?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, NameSearch.getText());
        pst.setString(2, SurnameSearch.getText());
        rs = pst.executeQuery();

        table1.setModel(DbUtils.resultSetToTableModel(rs));

} catch (SQLException ex) {
        Logger.getLogger(DatabaseP.class.getName()).log(Level.SEVERE, null, ex);
    }