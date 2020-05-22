TableCellRenderer renderer = new DefaultTableCellRenderer() {

    final JLabel headerLabel = new JLabel();
    {
        //setBorder(BorderFactory.createEmptyBorder());
        headerLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.WHITE);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        if (row == -1) {
            label.setText(value.toString());
            return headerLabel;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                  row, column);
    }

};