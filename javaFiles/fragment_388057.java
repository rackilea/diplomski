public static class ProxyCellRenderer implements TableCellRenderer {

    protected static final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);
    private TableCellRenderer renderer;

    public ProxyCellRenderer(TableCellRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (comp instanceof JComponent) {
            ((JComponent)comp).setBorder(DEFAULT_BORDER);
        }
        return comp;
    }        
}