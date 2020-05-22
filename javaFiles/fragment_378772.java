String sql = "SELECT * FROM sales WHERE date between ? and ?";
try (PreparedStatement pst = connection.prepareStatement(sql)) {
    pst.setString(1, new java.sql.Date(fromDate.getTime()));
    pst.setString(2, new java.sql.Date(toDate.getTime()));
    try (ResultSet rs = pst.executeQuery()) {
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    JOptionPane.showMessageDialog(null, "Monthly");
} catch (SQLException exp) {
    JOptionPane.showMessageDialog(null, ep);
}