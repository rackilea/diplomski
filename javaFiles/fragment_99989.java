removeBtn.addActionListener(new ActionListener(){
    public void removeRow(){
    int selRow = jEntityFilterTable.getSelectedRow();
    if(selRow != -1) {
        DefaultTableModel model = (DefaultTableModel)jEntityFilterTable.getModel();
        model.removeRow(selRow);
    }
}