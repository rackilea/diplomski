@Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        if (value.toString().equals("B")) {
            c.setForeground(Color.GREEN);
            c.setFont(c.getFont().deriveFont(Font.BOLD));
        } else if (value.toString().equals("D")) {
            c.setForeground(Color.BLUE);
            c.setFont(c.getFont().deriveFont(Font.BOLD));
        } else {
           c.setForeground(null);
           c.setFont(c.getFont().deriveFont(Font.PLAIN));
        }
        return this;
    }