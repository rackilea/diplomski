JTable table = new JTable(...)
{
    public Component prepareRenderer(
        TableCellRenderer renderer, int row, int column)
    {
        Component c = super.prepareRenderer(renderer, row, column);

        if (!isRowSelected(row))
        {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            boolean highlight = (Boolean)getModel().getValueAt(modelRow, ???);
            if (highlight) c.setBackground(Color.ORANGE);
        }

        return c;
    }
};