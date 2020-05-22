public HeaderRenderer(JTable table) {
    try {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        ...        
    } catch (ClassCastException e) { ... }
}