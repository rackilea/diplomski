@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
    Component comp = super.prepareRenderer(...);
    if (comp instanceof JLabel) {
        ((JLabel) comp).setHorizontalAlignment(...);
    }
    return comp;
}