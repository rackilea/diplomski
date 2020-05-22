JTable table = new JTable(...)
{
    public Component prepareRenderer(
        TableCellRenderer renderer, int row, int column)
    {
        Component c = super.prepareRenderer(renderer, row, column);
        c.setBackground(Color.WHITE);
        return c;
    }
};