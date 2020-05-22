while(rs.next())
{
    TableModel model = DbUtils.resultSetToTableModel(rs);
    jTable1.setModel(model);
    jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, 0, true));
}