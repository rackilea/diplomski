@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
    Component comp = super.prepareRenderer(renderer, row, column);
    int modelRow = convertRowIndexToModel(row);
    String second = this.getModel().getValueAt(modelRow, 1));
    String forth= this.getModel().getValueAt(modelRow, 3));
    if(second.equals(forth)){
        comp.setBackground(Color.GREEN);
    }
    return comp;
}