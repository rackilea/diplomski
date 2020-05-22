public abstract class AbstractTableAction<M extends TableModel> extends AbstractAction {
    private JTable table;
    private M model;

    public AbstractTableAction(JTable table, M model) {
        this.table = table;
        this.model = model;
    }

    public JTable getTable() {
        return table;
    }

    public M getModel() {
        return model;
    }
}