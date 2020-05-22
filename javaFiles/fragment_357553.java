int row = table.rowAtPoint(e.getPoint());
int column = table.columnAtPoint(e.getPoint());
table.changeSelection(row, column, false, false);
table.editCellAt(row, column);
Component c = table.getEditorComponent();

if (c instanceof JComboBox)
{
    JComboBox comboBox = (JComboBox)c;
    comboBox.showPopup();
}