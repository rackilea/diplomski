JTable table = new JTable(10, 5) {
    // make this a property in a custom table
    int visibleRows = 10;
    /**
     * Overridden to exactly fit a given number of rows/columns
     */
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        int height = visibleRows * getRowHeight();
        int width = getPreferredSize().width;
        return new Dimension(width, height);
    }

};