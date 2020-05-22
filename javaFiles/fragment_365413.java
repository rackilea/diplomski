public class DeleteRowAction extends AbstractTableAction<MutableTableModel> {
    public DeleteRowAction (JTable table, MutableTableModel model) {
        super(table, model);
        putValue(NAME, "Delete selected row(s)");
    }

    public void actionPerformed(ActionEvent evt) {
        JTable table = getTable();
        int rows[] = table.getSelectedRows();
        for (int index = 0; index < rows.length; index++) {
            rows[index] = table.convertRowIndexToModel(rows[index]);
        }
        getModel().removeRows(rows);
    }
}