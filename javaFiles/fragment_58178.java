DefaultRowSorter sorter = (DefaultRowSorter)table.getRowSorter();
...
sorter.addRowSorterListener(new RowSorterListener() {
    @Override
    public void sorterChanged(RowSorterEvent e) {
        if (e.getType() == RowSorterEvent.Type.SORTED) {
            // We need to call both revalidate() and repaint()
            table.revalidate();
            table.repaint();
        }
    }
});