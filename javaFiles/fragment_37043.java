class MyTable extends JTable {

    // all the other JTable stuff goes here too ...

    public TableCellRenderer getCellRenderer(int row, int column) {
        TableCellRenderer myRenderer = getCustomRenderer(row, column);
        if (myRenderer != null) {
            return myRenderer;
        }
        // else...
        return super.getCellRenderer(row, column);
    }

    private Map<Integer, Map<Integer, TableCellRenderer>> rendererMap = new ...;

    public void setCustomRenderer(int row, int column, TableCellRenderer renderer) {
        Map<Integer, TableCellRenderer> m1 = rendererMap.get(row);
        if (m1 == null) {
            m1 = new ...;
            rendererMap.put(row, m1);
        }
        m1.put(column, renderer);
    }

    public TableCellRenderer getCustomRenderer(int row, int column) {
        Map<Integer, TableCellRenderer> m1 = rendererMap.get(row);
        if (m1 == null) {
            return null;
        }
        return m1.get(column);
    }
}