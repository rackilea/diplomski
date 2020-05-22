public void example(){  

    TableColumn tmpColum =table.getColumnModel().getColumn(1);
    String[] DATA = { "Data 1", "Data 2", "Data 3", "Data 4" };
    JComboBox comboBox = new JComboBox(DATA);

    DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox);
    tmpColum.setCellEditor(defaultCellEditor);
    tmpColum.setCellRenderer(new CheckBoxCellRenderer(comboBox));
    table.repaint();
}


/**
   Custom class for adding elements in the JComboBox.
*/
class CheckBoxCellRenderer implements TableCellRenderer {
    JComboBox combo;
    public CheckBoxCellRenderer(JComboBox comboBox) {
    this.combo = new JComboBox();
    for (int i=0; i<comboBox.getItemCount(); i++){
        combo.addItem(comboBox.getItemAt(i));
    }
    }
    public Component getTableCellRendererComponent(JTable jtable, 
                           Object value, 
                           boolean isSelected, 
                           boolean hasFocus, 
                           int row, int column) {
    combo.setSelectedItem(value);
    return combo;
    }
}