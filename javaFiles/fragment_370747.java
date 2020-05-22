JTable table = ...;
TableModel model = ...;

int viewRow = table.getSelectedRow();
int modelRow = table.convertRowIndexToModel(viewRow);
int viewColumn = table.getSelectedColumn();
int modelColumn = table.convertColumnIndexToModel(viewColumn);
Object cell = model.getValueAt( modelRow, modelColumn );