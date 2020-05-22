public void checkCount(TableModel model) {
  int count=0;
  for (int row=0; row<model.getRowCount(); row++) {
    if ("Yes".equals(model.getValueAt(row, 3)) {
        count++;
    }
  }
  if (count>8) {
    JOptionPane.showMessageDialog(null, "Please remove a athlete from the team");
  }
}