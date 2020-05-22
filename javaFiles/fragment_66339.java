public void jTable1() {
    String a1 = jTextField1.getText();
    try {
        String sql = "select Instrument_ID, Name,Type,Version,Company,Status from Issue where Name like ? ";
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + a1 + "%");
        rs = pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}