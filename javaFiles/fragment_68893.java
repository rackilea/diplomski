public Dimension getPreferredSize() {
    Dimension d = super.getPreferredSize();
    d = (d == null) ? new Dimension(400,400) : d;
    Insets insets = getInsets();

    if (columns != 0) {
        d.width = Math.max(d.width, columns * getColumnWidth() +
                insets.left + insets.right);
    }
    if (rows != 0) {
        d.height = Math.max(d.height, rows * getRowHeight() +
                            insets.top + insets.bottom);
    }
    return d;
}