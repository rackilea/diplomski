private void swapElements(int pos1, int pos2) {
    File tmp = (File) listModel.get(pos1);
    listModel.set(pos1, listModel.get(pos2));
    listModel.set(pos2, tmp);
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    int indexOfSelected = jList1.getSelectedIndex();
    swapElements(indexOfSelected, indesOfSelected - 1);
    indexOfSelected = indexOfSelected - 1;
    jList1.setSelectedIndex(indexOfSelected );
    jList1.updateUI();
}