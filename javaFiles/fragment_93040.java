JTable table = new JTable(tableModel) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(SOME_WIDTH, N * table.getRowHeight());
    }
};