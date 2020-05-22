Date fday = day_chooser.getDate();
Date tday = day_chooser.getDate();
try {
    String sql = "SELECT *  FROM saleinfo WHERE SaleDate BETWEEN ? AND ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setDate(1, new java.sql.Date(fday.getTime()));
        pst.setDate(2, new java.sql.Date(tday.getTime()));
        try (ResultSet rs = pst.executeQuery()) {
            tbl.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error : " + ex);
    ex.printStackTrace();
}