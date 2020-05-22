public void actionPerformed(ActionEvent e) {
    String data1 = textField1.getTex();
    String data2 = textField2.getTex();
    String data3 = textField3.getTex();

    Object[] row = {dat1, data2, data3};
    model.addRow(row);
}