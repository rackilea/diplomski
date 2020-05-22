@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        String stringValue = (String) value;
        this.setText(stringValue);

        if (isSelected)
        {
            this.setBackground(table.getSelectionBackground());
            this.setForeground(table.getSelectionForeground());
        } else
        {
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }

        return this;
    }
}