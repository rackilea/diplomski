@Override
public void mouseClicked(MouseEvent me) {
    if (me.getClickCount()==2){
        int selectedRow = jTable1.getSelectedRow();
        int selectedColumn = jTable1.getSelectedColumn();
        if (selectedRow > -1 && selectedColumn > -1) {
            Object value = jTable1.getValueAt(selectedRow, selectedColumn); // ask the value to the view, not the model. Otherwise you need to convert both row and column indexes
            this.updateText.updateText(value.toString());
            this.setVisible(false); // maybe this.dispose() instead ?
        }
    }
}