private <T> EventTableModel<T> setupTable(JXTable table, TableFormat<T> tf, EventList<T> displayItems, SortedList<T> sortedItems)
{
    table.setColumnControlVisible(true);
    table.setSortable(false);
    table.getTableHeader().setDefaultRenderer(new JTableHeader().getDefaultRenderer());
table.setAutoCreateRowSorter(false);
table.setRowSorter(null);

    EventTableModel<T> etm = new EventTableModel<T>(displayItems, tf);
    table.setModel(etm);

    TableComparatorChooser.install(table, sortedItems, AbstractTableComparatorChooser.SINGLE_COLUMN);
    return etm;
}