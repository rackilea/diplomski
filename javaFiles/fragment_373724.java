void func(Object jTable) { 
 //YOURCLASS jTable5 = (YOURCLASS) jTable;
 JTable jTable5 = (JTable) jTable;
 DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
 model.removeRow(jTable5.getSelectedRow());
 jTable5.remove(jTable5.getSelectedRow());
 jTable5.revalidate();
}