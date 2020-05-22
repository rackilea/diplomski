headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JComponent component = (JComponent)table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, false, false, -1, -2);
            component.setBackground(new Color(250, 250, 250));
            component.setBorder(BorderFactory.createEmptyBorder());
            return component;
        }
    });