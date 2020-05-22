JTable table = new JTable(tableModel) {
    @Override
    public void sorterChanged(RowSorterEvent e) {
        super.sorterChanged(e);
        if (e.getType() == RowSorterEvent.Type.SORTED) {
            resizeAndRepaint(); // this protected method calls both revalidate() and repaint()
        }
    }
};