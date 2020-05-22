@Override
public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
    Component comp = super.prepareRenderer(renderer, rowIndex, vColIndex);

    if (isRowSelected(rowIndex)) {
        comp.setBackground(Color.ORANGE);
    }

    return comp;
}