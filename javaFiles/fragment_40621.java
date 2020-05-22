private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    String txt1 = (String) JComboBox1.getSelectedItem();
    String txt2 = (String) JComboBox2.getSelectedItem();
    jComboBox1.setSelectedItem(txt2);
    jComboBox2.setSelectedItem(txt1);
}