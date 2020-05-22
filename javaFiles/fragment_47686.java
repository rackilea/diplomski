tableR = new JTable(modelR) {
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        Font myFont = new Font("Arial",Font.PLAIN,10);
        Font myFont1 = new Font("Arial", Font.BOLD,10);
        int rowModelId = convertRowIndexToModel( row );
        int rowModelId1 = convertRowIndexToModel( row );
    if (!isRowSelected(row)) {
        if (tableR.getColumnCount() >= 0) {
            String type = (String) getModel().getValueAt(rowModelId1, 12);
            if("u".equals(type)) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.WHITE);
                c.setFont(myFont1);
                return c;
            }
            type = (String) getModel().getValueAt(rowModelId, 11);
            if("0.0".equals(type)) {
                c.setBackground(Color.RED);
                c.setForeground(Color.WHITE);
                c.setFont(myFont1);
                return c;
            }
        }
        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
        c.setFont(myFont);
    }
    return c;
}
}