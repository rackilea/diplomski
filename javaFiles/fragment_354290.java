protected void paintCell(Graphics g, int row, Rectangle rowBounds,
        ListCellRenderer cellRenderer, ListModel dataModel,
        ListSelectionModel selModel, int leadIndex) {
    Object value = dataModel.getElementAt(row);
    boolean cellHasFocus = list.hasFocus() && (row == leadIndex);
    boolean isSelected = selModel.isSelectedIndex(row);

    Component rendererComponent = cellRenderer
            .getListCellRendererComponent(list, value, row, isSelected,
                    cellHasFocus);

    int cx = rowBounds.x;
    int cy = rowBounds.y;
    int cw = rowBounds.width;
    int ch = rowBounds.height;

    if (isFileList) {
        // Shrink renderer to preferred size. This is mostly used on Windows
        // where selection is only shown around the file name, instead of
        // across the whole list cell.
        int w = Math
                .min(cw, rendererComponent.getPreferredSize().width + 4);
        if (!isLeftToRight) {
            cx += (cw - w);
        }
        cw = w;
    }

    rendererPane.paintComponent(g, rendererComponent, list, cx, cy, cw, ch,
            true);
}