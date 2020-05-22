DefaultTableModel model = (DefaultTableModel)table.getModel();
for (int i = 0; i < length; i++) {
    data = new Object[6];
    data[0] = checkBands[i];
    data[1] = true;
    data[2] = 1;
    data[3] = 2;
    data[4] = 3;
    data[5] = 4;
    model.addRow(data);
}